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
    /// Interaction logic for PacientView.xaml
    /// </summary>
    public partial class PacientMedicView : UserControl
    {
        public PacientViewModel ViewModel { get; set; }
        public PacientMedicView()
        {
            InitializeComponent();
            ViewModel = new PacientViewModel();
            DataContext = ViewModel;
        }
    }
}
