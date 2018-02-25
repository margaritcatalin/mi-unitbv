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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Numere_pare
{
    /// <summary>
    /// Interaction logic for UserControl1.xaml
    /// </summary>
    public partial class UserControl1 : UserControl
    {
        public UserControl1()
        {
            InitializeComponent();
        }

        private void ButtonLogin_Click(object sender, RoutedEventArgs e)
        {
            if (User.Text == "Test" && Pass.Text == "test123")
            {
                //MessageBox.Show("Bine ati venit, Test!");
                MainWindow main = new MainWindow();
                Window.GetWindow(this).Close();
                App.Current.MainWindow = main;
                main.Show();
            }
            else
            {
                MessageBox.Show("Datele introduse nu sunt corecte.");
            }

        }
    }
}
