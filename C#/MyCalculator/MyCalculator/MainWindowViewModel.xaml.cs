using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace MyCalculator
{
    /// <summary>
    /// Interaction logic for MainWindowViewModel.xaml
    /// </summary>
    public partial class MainWindowViewModel : Window
    {
        private Calculator calculator = null;
        private string _currentValue = "0";
        public MainWindowViewModel()
        {
            calculator = new Calculator();
        }
        public string CurrentValue
        {
            get
            {
                return _currentValue;
            }
            set
            {
                if (_currentValue == value)
                    return;

                _currentValue = value;
            }
        }
    }
}
