using System;
using System.Windows;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Globalization;
using System.Threading;

namespace MyCalculator
{
    /// <summary>
    /// Interaction logic for xaml
    /// </summary>
    public partial class Calculator : Window
    {
        private enum SecondArgumentAction
        {
            None,
            Add,
            Substract,
            Multiply,
            Divide,
            Percent,
            Clear
        }
        private enum DigitGroup
        {
            None,
            ROM,
            ENG
        }
        private SecondArgumentAction _operator = SecondArgumentAction.None;
        private double _value = 0;
        private double _memValue = 0;
        private string resultText = "0";
        private double percentvalue;
        private string _decimalDelimiter = CultureInfo.CurrentCulture.NumberFormat.NumberDecimalSeparator;
        private NumberFormatInfo _invariantNF = CultureInfo.InvariantCulture.NumberFormat;
        private DigitGroup culture = DigitGroup.ROM;
        public KeyReact NumberZeroKey { get; private set; }
        public KeyReact NumberOneKey { get; private set; }
        public KeyReact NumberTwoKey { get; private set; }
        public KeyReact NumberThreeKey { get; private set; }
        public KeyReact NumberFourKey { get; private set; }
        public KeyReact NumberFifeKey { get; private set; }
        public KeyReact NumberSixKey { get; private set; }
        public KeyReact NumberSevenKey { get; private set; }
        public KeyReact NumberEightKey { get; private set; }
        public KeyReact NumberNineKey { get; private set; }
        public KeyReact NumberDecimalDotKey { get; private set; }
        public KeyReact CalculateDivideKey { get; private set; }
        public KeyReact CalculateMultiplyKey { get; private set; }
        public KeyReact CalculateSubtractKey { get; private set; }
        public KeyReact CalculateAddKey { get; private set; }
        public KeyReact CalculateResultKey { get; private set; }
        public KeyReact PercentKey { get; private set; }
        public KeyReact DeleteLastKey { get; private set; }
        public Calculator()
        {
            InitializeComponent();
            this.DataContext = this;
            NumberZeroKey = new KeyReact(NumberZero_Action);
            NumberOneKey = new KeyReact(NumberOne_Action);
            NumberTwoKey = new KeyReact(NumberTwo_Action);
            NumberThreeKey = new KeyReact(NumberThree_Action);
            NumberFourKey = new KeyReact(NumberFour_Action);
            NumberFifeKey = new KeyReact(NumberFife_Action);
            NumberSixKey = new KeyReact(NumberSix_Action);
            NumberSevenKey = new KeyReact(NumberSeven_Action);
            NumberEightKey = new KeyReact(NumberEight_Action);
            NumberNineKey = new KeyReact(NumberNine_Action);
            NumberDecimalDotKey = new KeyReact(NumberDecimalDot_Action);

            CalculateDivideKey = new KeyReact(CalculateDivide_Action);
            CalculateMultiplyKey = new KeyReact(CalculateMultiply_Action);
            CalculateSubtractKey = new KeyReact(CalculateSubtract_Action);
            CalculateAddKey = new KeyReact(CalculateAdd_Action);
            CalculateResultKey = new KeyReact(CalculateResult_Action);
            PercentKey = new KeyReact(Percent_Action);
            DeleteLastKey = new KeyReact(DeleteLast_Action);
            System.Windows.Forms.NotifyIcon ni = new System.Windows.Forms.NotifyIcon();
            ni.Icon = new System.Drawing.Icon("Main.ico");
            ni.Visible = true;
            ni.DoubleClick +=
                delegate (object sender, EventArgs args)
                {
                    this.Show();
                    this.WindowState = WindowState.Normal;
                };
        }
        protected override void OnStateChanged(EventArgs e)
        {
            if (WindowState == WindowState.Minimized)
                this.Hide();

            base.OnStateChanged(e);
        }
        private void MenuItemFileCopy_Click(object sender, RoutedEventArgs e)
        {
            Clipboard.SetText(resultText);
        }
        private void MenuItemFilePaste_Click(object sender, RoutedEventArgs e)
        {
            string rawPastable = Clipboard.GetText();
            ProcessClipboardPasteToEntry(rawPastable);
        }
        private void ProcessClipboardPasteToEntry(object result)
        {
            if (result != null)
            {
                string rawPastable = result.ToString();
                string cleanPastable = "";

                for (int charIndex = 0; charIndex < rawPastable.Length; charIndex++)
                {
                    if (char.IsDigit(rawPastable[charIndex]))
                        cleanPastable += rawPastable[charIndex];
                    else
                    {
                        string s = rawPastable.Substring(charIndex, 1);
                        if (_decimalDelimiter == s || "." == s)
                            cleanPastable += _decimalDelimiter;
                        else
                            break;
                    }
                }

                if (!string.IsNullOrEmpty(cleanPastable))
                {
                    double d = 0;
                    if (double.TryParse(cleanPastable, out d) == true)
                    {
                        resultText = d.ToString();
                        DigitGrouping(resultText);
                    }
                }
            }
        }
        private void MenuItemFileExit_Click(object sender, RoutedEventArgs e)
        {
            Application.Current.MainWindow.Close();
        }
        private void MenuItemQmarkAbout_Click(object sender, RoutedEventArgs e)
        {
            AboutBox box = new AboutBox();
            box.ShowDialog();
        }
        private void EditDeleteLast_Click(object sender, RoutedEventArgs e)
        {
            DeleteLast_Action(sender);
        }
        public void DeleteLast_Action(object o)
        {
            resultText = resultText.Substring(0, resultText.Length - 1);

            if (String.IsNullOrEmpty(resultText))
                resultText = "0";
            DigitGrouping(resultText);
        }
        private void DigitGrouping(string resutText)
        {
            double afisare;
            string zecimal = "0";
            int indexpoint = resultText.IndexOf('.');
            if (indexpoint != -1)
                zecimal = resultText.Substring(indexpoint + 1);
            if (culture == DigitGroup.ROM)
            {
                afisare = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
                Entry.Text = afisare.ToString(afisare % 1 == 0 ? "N0" : "N" + zecimal.Length, new CultureInfo("ro-RO"));
            }
            else if (culture == DigitGroup.ENG)
            {
                afisare = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
                Entry.Text = afisare.ToString(afisare % 1 == 0 ? "N0" : "N" + zecimal.Length, new CultureInfo("en-US"));
            }
        }
        private void EditClearEntry_Click(object sender, RoutedEventArgs e)
        {
            resultText = "0";
            DigitGrouping(resultText);
        }
        private void EditClearAll_Click(object sender, RoutedEventArgs e)
        {
            _operator = SecondArgumentAction.None;
            resultText = "0";
            Info.Text = "";
            _value = 0;
            DigitGrouping(resultText);
        }
        private void NumberZero_Click(object sender, RoutedEventArgs e)
        { NumberZero_Action(sender); }
        public void NumberZero_Action(object o)
        {
            if (_operator == SecondArgumentAction.Clear)
            {
                resultText = "0";
                _operator = SecondArgumentAction.None;
            }

            if (resultText == "0")
                resultText = "0";
            else
                resultText += "0";
            DigitGrouping(resultText);
        }
        private void NumberOne_Click(object sender, RoutedEventArgs e)
        { NumberOne_Action(sender); }

        public void NumberOne_Action(object o)
        {
            if (_operator == SecondArgumentAction.Clear)
            {
                resultText = "0";
                _operator = SecondArgumentAction.None;
            }

            if (resultText == "0")
                resultText = "1";
            else
                resultText += "1";
            DigitGrouping(resultText);
        }
        private void NumberTwo_Click(object sender, RoutedEventArgs e)
        { NumberTwo_Action(sender); }

        public void NumberTwo_Action(object o)
        {
            if (_operator == SecondArgumentAction.Clear)
            {
                resultText = "0";
                _operator = SecondArgumentAction.None;
            }

            if (resultText == "0")
                resultText = "2";
            else
                resultText += "2";
            DigitGrouping(resultText);
        }
        private void NumberThree_Click(object sender, RoutedEventArgs e)
        { NumberThree_Action(sender); }
        public void NumberThree_Action(object o)
        {
            if (_operator == SecondArgumentAction.Clear)
            {
                resultText = "0";
                _operator = SecondArgumentAction.None;
            }

            if (resultText == "0")
                resultText = "3";
            else
                resultText += "3";
            DigitGrouping(resultText);
        }
        private void NumberFour_Click(object sender, RoutedEventArgs e)
        { NumberFour_Action(sender); }
        public void NumberFour_Action(object o)
        {
            if (_operator == SecondArgumentAction.Clear)
            {
                resultText = "0";
                _operator = SecondArgumentAction.None;
            }

            if (resultText == "0")
                resultText = "4";
            else
                resultText += "4";
            DigitGrouping(resultText);
        }

        private void NumberFife_Click(object sender, RoutedEventArgs e)
        { NumberFife_Action(sender); }

        public void NumberFife_Action(object o)
        {
            if (_operator == SecondArgumentAction.Clear)
            {
                resultText = "0";
                _operator = SecondArgumentAction.None;
            }

            if (resultText == "0")
                resultText = "5";
            else
                resultText += "5";
            DigitGrouping(resultText);
        }
        private void NumberSix_Click(object sender, RoutedEventArgs e)
        { NumberSix_Action(sender); }
        public void NumberSix_Action(object o)
        {
            if (_operator == SecondArgumentAction.Clear)
            {
                resultText = "0";
                _operator = SecondArgumentAction.None;
            }

            if (resultText == "0")
                resultText = "6";
            else
                resultText += "6";
            DigitGrouping(resultText);
        }
        private void NumberSeven_Click(object sender, RoutedEventArgs e)
        { NumberSeven_Action(sender); }
        public void NumberSeven_Action(object o)
        {
            if (_operator == SecondArgumentAction.Clear)
            {
                resultText = "0";
                _operator = SecondArgumentAction.None;
            }

            if (resultText == "0")
                resultText = "7";
            else
                resultText += "7";
            DigitGrouping(resultText);
        }
        private void NumberEight_Click(object sender, RoutedEventArgs e)
        { NumberEight_Action(sender); }

        public void NumberEight_Action(object o)
        {
            if (_operator == SecondArgumentAction.Clear)
            {
                resultText = "0";
                _operator = SecondArgumentAction.None;
            }

            if (resultText == "0")
                resultText = "8";
            else
                resultText += "8";
            DigitGrouping(resultText);
        }
        private void NumberNine_Click(object sender, RoutedEventArgs e)
        { NumberNine_Action(sender); }
        public void NumberNine_Action(object o)
        {
            if (_operator == SecondArgumentAction.Clear)
            {
                resultText = "0";
                _operator = SecondArgumentAction.None;
            }

            if (resultText == "0")
                resultText = "9";
            else
                resultText += "9";
            DigitGrouping(resultText);
        }
        private void NumberDecimalDot_Click(object sender, RoutedEventArgs e)
        { NumberDecimalDot_Action(sender); }
        public void NumberDecimalDot_Action(object o)
        {
            if (_operator == SecondArgumentAction.Clear)
                resultText = "0";

            resultText += ".";
            Entry.Text = resultText;
        }
        private void CalculateNegate_Click(object sender, RoutedEventArgs e)
        {
            _value = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
            _value = -(_value);
            resultText = Convert.ToString(_value).Replace(_decimalDelimiter, ".");
            DigitGrouping(resultText);
        }
        private void CalculateDivide_Click(object sender, RoutedEventArgs e)
        { CalculateDivide_Action(sender); }
        public void CalculateDivide_Action(object o)
        {
            if (_operator != SecondArgumentAction.Clear &&
                _operator != SecondArgumentAction.None)
                CalculateResult_Action(o);

            _operator = SecondArgumentAction.Divide;
            _value = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
            resultText = "0";

            Info.Text = _value.ToString() + " /";
            DigitGrouping(resultText);
        }
        private void CalculateMultiply_Click(object sender, RoutedEventArgs e)
        { CalculateMultiply_Action(sender); }

        public void CalculateMultiply_Action(object o)
        {
            if (_operator != SecondArgumentAction.Clear &&
                _operator != SecondArgumentAction.None)
                CalculateResult_Action(o);

            _operator = SecondArgumentAction.Multiply;
            _value = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
            resultText = "0";

            Info.Text = _value.ToString() + " *";
            DigitGrouping(resultText);
        }
        private void CalculateSubtract_Click(object sender, RoutedEventArgs e)
        { CalculateSubtract_Action(sender); }
        public void CalculateSubtract_Action(object o)
        {
            if (_operator != SecondArgumentAction.Clear &&
                _operator != SecondArgumentAction.None)
                CalculateResult_Action(o);

            _operator = SecondArgumentAction.Substract;
            _value = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
            resultText = "0";

            Info.Text = _value.ToString() + " -";
            DigitGrouping(resultText);
        }
        private void CalculateAdd_Click(object sender, RoutedEventArgs e)
        { CalculateAdd_Action(sender); }
        public void CalculateAdd_Action(object o)
        {
            if (_operator != SecondArgumentAction.Clear &&
                _operator != SecondArgumentAction.None)
                CalculateResult_Action(o);

            _operator = SecondArgumentAction.Add;
            _value = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
            resultText = "0";

            Info.Text = _value.ToString() + " +";
            DigitGrouping(resultText);
        }
        private void CalculateSqrt_Click(object sender, RoutedEventArgs e)
        {
            double dTemp = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
            dTemp = Math.Sqrt(dTemp);
            resultText = Convert.ToString(dTemp).Replace(_decimalDelimiter, ".");
            _operator = SecondArgumentAction.Clear;
            DigitGrouping(resultText);
        }
        private void CalculateSquare_Click(object sender, RoutedEventArgs e)
        {
            double dTemp = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
            dTemp *= dTemp;
            resultText = Convert.ToString(dTemp).Replace(_decimalDelimiter, ".");
            _operator = SecondArgumentAction.Clear;
            DigitGrouping(resultText);
        }
        private void CalculateReciprocal_Click(object sender, RoutedEventArgs e)
        {
            double dTemp = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
            dTemp = 1.0 / dTemp;
            resultText = Convert.ToString(dTemp).Replace(_decimalDelimiter, ".");
            _operator = SecondArgumentAction.Clear;
            DigitGrouping(resultText);
        }
        private void CalculateResult_Click(object sender, RoutedEventArgs e)
        { CalculateResult_Action(sender); }
        public void CalculateResult_Action(object o)
        {
            double dTemp = _value;
            _value = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
            switch (_operator)
            {
                case SecondArgumentAction.Add:
                    resultText = Convert.ToString(dTemp + _value).Replace(_decimalDelimiter, ".");
                    _operator = SecondArgumentAction.Clear;
                    DigitGrouping(resultText);
                    break;
                case SecondArgumentAction.Substract:
                    resultText = Convert.ToString(dTemp - _value).Replace(_decimalDelimiter, ".");
                    _operator = SecondArgumentAction.Clear;
                    DigitGrouping(resultText);
                    break;
                case SecondArgumentAction.Multiply:
                    resultText = Convert.ToString(dTemp * _value).Replace(_decimalDelimiter, ".");
                    _operator = SecondArgumentAction.Clear;
                    DigitGrouping(resultText);
                    break;
                case SecondArgumentAction.Divide:
                    if (_value != 0.0)
                        resultText = Convert.ToString(dTemp / _value).Replace(_decimalDelimiter, ".");
                    else
                        resultText = Convert.ToString(System.Double.MaxValue).Replace(_decimalDelimiter, ".");
                    _operator = SecondArgumentAction.Clear;
                    if (_value == 0)
                    {
                        Entry.Text = "∞";
                        break;
                    }
                    DigitGrouping(resultText);
                    break;
                case SecondArgumentAction.Percent:
                    if (_value != 0.0)
                        resultText = Convert.ToString(percentvalue * _value / 100.0).Replace(_decimalDelimiter, ".");
                    else
                    {
                        resultText = Convert.ToString(percentvalue * _value / 100.0).Replace(_decimalDelimiter, ".");
                    }
                    if (_value == 0)
                    {
                        Entry.Text = "∞";
                        break;
                    }
                    _operator = SecondArgumentAction.Clear;
                    DigitGrouping(resultText);
                    break;
            }
            if (_operator == SecondArgumentAction.Clear)
                Info.Text = "";
        }
        private void MemoryClear_Click(object sender, RoutedEventArgs e)
        {
            Memory.Text = "";
            _memValue = 0;
        }
        private void MemoryRecall_Click(object sender, RoutedEventArgs e)
        {
            if (String.IsNullOrEmpty(Memory.Text))
                return;
            resultText = Convert.ToString(_memValue).Replace(_decimalDelimiter, ".");
            DigitGrouping(resultText);
        }

        private void MemorySave_Click(object sender, RoutedEventArgs e)
        {
            _memValue = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
            if (_memValue != 0.0)
                Memory.Text = "M";
            else
                Memory.Text = "";
        }
        private void MemoryAdd_Click(object sender, RoutedEventArgs e)
        {
            _memValue += Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
            if (_memValue != 0.0)
                Memory.Text = "M";
            else
                Memory.Text = "";
        }
        private void MemorySubstract_Click(object sender, RoutedEventArgs e)
        {
            _memValue -= Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
            if (_memValue != 0.0)
                Memory.Text = "M";
            else
                Memory.Text = "";
        }

        private void MenuItemFileDigitGrouping_Click(object sender, RoutedEventArgs e)
        {
            double afisare;
            string zecimal = "0";
            int indexpoint = resultText.IndexOf('.');
            if (indexpoint != -1)
                zecimal = resultText.Substring(indexpoint + 1);
            if (culture == DigitGroup.ROM)
            {
                culture = DigitGroup.ENG;
                afisare = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
                Entry.Text = afisare.ToString(afisare % 1 == 0 ? "N0" : "N" + zecimal.Length, new CultureInfo("ro-RO"));
            }
            else if (culture == DigitGroup.ENG)
            {
                culture = DigitGroup.ROM;
                afisare = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
                Entry.Text = afisare.ToString(afisare % 1 == 0 ? "N0" : "N" + zecimal.Length, new CultureInfo("en-US"));
            }
        }

        private void MenuItemFileCut_Click(object sender, RoutedEventArgs e)
        {
            Clipboard.SetText(resultText);
            resultText = "0";
            DigitGrouping(resultText);
        }
        private void Percent_Click(object sender, RoutedEventArgs e)
        {
            Percent_Action(sender);
        }
        public void Percent_Action(object o)
        {
            if (_operator != SecondArgumentAction.Clear &&
                _operator != SecondArgumentAction.None)
                CalculateResult_Action(o);

            _operator = SecondArgumentAction.Percent;
            _value = Convert.ToDouble(resultText.Replace(_decimalDelimiter, "."), _invariantNF);
            resultText = "0";
            percentvalue = _value;
            Info.Text = _value.ToString() + " %";
            DigitGrouping(resultText);
        }
    }
}
