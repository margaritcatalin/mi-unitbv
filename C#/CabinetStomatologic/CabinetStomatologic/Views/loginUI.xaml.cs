using CabinetStomatologic.BLL;
using CabinetStomatologic.Models;
using CabinetStomatologic.Utils;
using CabinetStomatologic.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
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
using System.Windows.Threading;

namespace CabinetStomatologic.Views
{
    /// <summary>
    /// Interaction logic for loginUI.xaml
    /// </summary>
    public partial class loginUI : UserControl
    {
        AccountBLL accountBLL = new AccountBLL();
        public loginUI()
        {
            InitializeComponent();
            txtName.Focus();
            DispatcherTimer timer = new DispatcherTimer(new TimeSpan(0, 0, 1), DispatcherPriority.Normal, delegate
            {
                this.CurrentTime.Content = DateTime.Now.ToLongTimeString();
            }, this.Dispatcher);
        }
        private void login_click(object sender, RoutedEventArgs e)
        {
            login_btn.IsEnabled = false;
            String user = txtName.Text;
            String pass = txtpassword.Password;
            Account loguser;
            new Thread(() =>
            {
                if ((loguser = accountBLL.GetAccount(user, pass)) != null)
                {
                    if (loguser.Role.Equals("admin")|| loguser.Role.Equals("Admin"))
                    {
                        this.Dispatcher.Invoke(new Action(delegate
                        {
                            Switcher.stacktest.Navigate(new DashBaord(new AccountsViewModel()));
                        }));
                    }
                    else if (loguser.Role.Equals("doctor") || loguser.Role.Equals("Doctor"))
                    {
                        this.Dispatcher.Invoke(new Action(delegate
                        {
                            Switcher.stacktest.Navigate(new DashBoardMedic(new InterventieViewModel(), loguser));
                        }));
                    }
                    else
                        return;
                }
                else
                {
                    this.Dispatcher.Invoke(new Action(delegate
                    {
                        txtName.Text = "";
                        txtpassword.Password = "";
                        txtName.Focus();
                        lberror.Content = " Invalid username/password!";
                        login_btn.IsEnabled = true;
                    }));
                }
            }).Start();
        }

        private void txtpassword_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.Key == Key.Enter)
            {
                login_click(null, null);
            }
        }
    }
}