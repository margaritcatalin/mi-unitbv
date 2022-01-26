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
    /// Interaction logic for ProgramariCurenteView.xaml
    /// </summary>
    public partial class ProgramariCurenteView : UserControl
    {
        public ProgramariCurenteVM ViewModel { get; set; }
        public ProgramariCurenteView()
        {
            InitializeComponent();
            ViewModel = new ProgramariCurenteVM();
            DataContext = ViewModel;
        }
    }
}
