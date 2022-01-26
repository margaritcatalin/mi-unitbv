using CabinetStomatologic.BLL;
using CabinetStomatologic.Models;
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
    /// Interaction logic for AccountsView.xaml
    /// </summary>
    public partial class InterventieView : UserControl
    {
        public InterventieViewModel ViewModel { get; set; }
        public InterventieView()
        {
            InitializeComponent();
            ViewModel = new InterventieViewModel();
            DataContext = ViewModel;
            if (DashBaord.ViewModel != null)
                DashBaord.ViewModel.CloseRootDialog();
            else
                DashBoardMedic.ViewModel.CloseRootDialog();
        }
    }
}
