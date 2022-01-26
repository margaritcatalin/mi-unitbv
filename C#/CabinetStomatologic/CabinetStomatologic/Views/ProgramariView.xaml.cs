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
    /// Interaction logic for ProgramariView.xaml
    /// </summary>
    public partial class ProgramariView : UserControl
    {
        public ProgramareViewModel ViewModel { get; set; }
        public ProgramariView()
        {
            InitializeComponent();
            ViewModel = new ProgramareViewModel();
            DataContext = ViewModel;
            if(DashBaord.ViewModel!=null)
                DashBaord.ViewModel.CloseRootDialog();
            else
                DashBoardMedic.ViewModel.CloseRootDialog();
        }
        private void InterventieComboBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            ProgramareBLL p = new ProgramareBLL();
           // ((ProgramareViewModel)DataContext).ProgramareList = p.GetProgramareForInterventie(((ComboBox)sender).SelectedItem as Interventie);
        }
        private void PacientComboBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            ProgramareBLL p = new ProgramareBLL();
           // ((ProgramareViewModel)DataContext).ProgramareList = p.GetProgramareForPacient(((ComboBox)sender).SelectedItem as Pacient);
        }
    }
}
