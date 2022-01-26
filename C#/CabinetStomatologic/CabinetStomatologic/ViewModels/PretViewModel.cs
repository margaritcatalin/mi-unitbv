using CabinetStomatologic.BLL;
using CabinetStomatologic.Models;
using CabinetStomatologic.Utils;
using CabinetStomatologic.Views;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace CabinetStomatologic.ViewModels
{
    public class PretViewModel : BaseViewModel
    {
        PretBLL acBLL = new PretBLL();
        public PretViewModel()
        {
            PretList = acBLL.GetAllPret();
            DataInceputDatePicker = DateTime.Now;
            DataFinalDatePicker = DateTime.Now.AddDays(1);
            if (DashBaord.ViewModel != null)
                DashBaord.ViewModel.CloseRootDialog();
            else
                DashBoardMedic.ViewModel.CloseRootDialog();
        }
        #region Data Members
        public DateTime DataInceputDatePicker { get; set; }
        public DateTime DataFinalDatePicker { get; set; }
        public ObservableCollection<Pret> PretList
        {
            get
            {
                return acBLL.PretList;
            }
            set
            {
                acBLL.PretList = value;
            }
        }
        #endregion
        #region ICommand Members

        private ICommand addCommand;
        public ICommand AddCommand
        {
            get
            {
                if (addCommand == null)
                {
                    addCommand = new RelayCommand<Pret>(acBLL.AddPret);
                }
                return addCommand;
            }
            set
            {
                addCommand = value;
            }
        }

        private ICommand updateCommand;
        public ICommand UpdateCommand
        {
            get
            {
                if (updateCommand == null)
                {
                    updateCommand = new RelayCommand<Pret>(acBLL.ModifyPret);
                }
                return updateCommand;
            }
            set
            {
                updateCommand = value;
            }
        }

        private ICommand deleteCommand;
        public ICommand DeleteCommand
        {
            get
            {
                if (deleteCommand == null)
                {
                    deleteCommand = new RelayCommand<Pret>(acBLL.DeletePret);
                }
                return deleteCommand;
            }
            set
            {
                deleteCommand = value;
            }
        }
        #endregion
    }
}
