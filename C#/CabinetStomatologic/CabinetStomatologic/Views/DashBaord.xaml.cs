using CabinetStomatologic.Utils;
using CabinetStomatologic.ViewModels;
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

namespace CabinetStomatologic.Views
{
    /// <summary>
    /// Interaction logic for DashBaord.xaml
    /// </summary>
    public partial class DashBaord : UserControl
    {
        public static HomeViewModel ViewModel { get; set; }

        public DashBaord(BaseViewModel model)
        {
            ViewModel = new HomeViewModel(model);
            DataContext = ViewModel;
            InitializeComponent();
        }

        private void navigateToInterventie(object sender, MouseButtonEventArgs e)
        {
            this.Dispatcher.Invoke(new Action(delegate
            {
                Switcher.stacktest.Navigate(new DashBaord(new InterventieViewModel()));
            }));
        }
        private void navigateToLogin(object sender, RoutedEventArgs e)
        {
            Switcher.stacktest.Navigate(new loginUI());
        }
        private void navigateToAccounts(object sender, MouseButtonEventArgs e)
        {
            this.Dispatcher.Invoke(new Action(delegate
            {
                Switcher.stacktest.Navigate(new DashBaord(new AccountsViewModel()));
            }));
        }
        private void navigateToPatients(object sender, RoutedEventArgs e)
        {
            this.Dispatcher.Invoke(new Action(delegate
            {
                Switcher.stacktest.Navigate(new DashBaord(new PacientViewModel()));
            }));
        }

        private void navigateToPret(object sender, RoutedEventArgs e)
        {
            this.Dispatcher.Invoke(new Action(delegate
            {
                Switcher.stacktest.Navigate(new DashBaord(new PretViewModel()));
            }));
        }

        private void navigateToProgramari(object sender, RoutedEventArgs e)
        {
            this.Dispatcher.Invoke(new Action(delegate
            {
                Switcher.stacktest.Navigate(new DashBaord(new ProgramareViewModel()));
            }));
        }
    }
}
