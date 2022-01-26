using CabinetStomatologic.Models;
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
    /// Interaction logic for DashBoardMedic.xaml
    /// </summary>
    public partial class DashBoardMedic : UserControl
    {
        public static HomeViewModel ViewModel { get; set; }
        public static Account user;
        public DashBoardMedic(BaseViewModel model, Account u)
        {
            ViewModel = new HomeViewModel(model);
            user = u;
            DataContext = ViewModel;
            InitializeComponent();
        }

        private void navigateToInterventie(object sender, MouseButtonEventArgs e)
        {
            this.Dispatcher.Invoke(new Action(delegate
            {
                Switcher.stacktest.Navigate(new DashBoardMedic(new InterventieViewModel(), user));
            }));
        }

        private void navigateToPatients(object sender, RoutedEventArgs e)
        {
            this.Dispatcher.Invoke(new Action(delegate
            {
                Switcher.stacktest.Navigate(new DashBoardMedic(new PacientViewModel(), user));
            }));
        }
        private void navigateToProgramariCurente(object sender, RoutedEventArgs e)
        {
            this.Dispatcher.Invoke(new Action(delegate
            {
                Switcher.stacktest.Navigate(new DashBoardMedic(new ProgramariCurenteVM(), user));
            }));
        }
        private void navigateToPret(object sender, RoutedEventArgs e)
        {
            this.Dispatcher.Invoke(new Action(delegate
            {
                Switcher.stacktest.Navigate(new DashBoardMedic(new PretViewModel(), user));
            }));
        }

        private void navigateToProgramari(object sender, RoutedEventArgs e)
        {
            this.Dispatcher.Invoke(new Action(delegate
            {
                Switcher.stacktest.Navigate(new DashBoardMedic(new ProgramareViewModel(), user));
            }));
        }
        private void navigateToLogin(object sender, RoutedEventArgs e)
        {
            Switcher.stacktest.Navigate(new loginUI());
        }
    }
}