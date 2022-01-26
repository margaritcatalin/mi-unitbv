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
    public class PacientViewModel : BaseViewModel
    {
        PacientBLL acBLL = new PacientBLL();
        public PacientViewModel()
        {
            PacientList = acBLL.GetAllPacient();
            if (DashBoardMedic.user != null)
                PacientMedicList = acBLL.GetAllPacientMedic(DashBoardMedic.user.AccountID);
        }
        #region Data Members
        public ObservableCollection<Pacient> PacientMedicList
        {
            get
            {
                return acBLL.PacientMedicList;
            }
            set
            {
                acBLL.PacientMedicList = value;
            }
        }
        public ObservableCollection<Pacient> PacientList
        {
            get
            {
                return acBLL.PacientList;
            }
            set
            {
                acBLL.PacientList = value;
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
                    addCommand = new RelayCommand<Pacient>(acBLL.AddPacient);
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
                    updateCommand = new RelayCommand<Pacient>(acBLL.ModifyPacient);
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
                    deleteCommand = new RelayCommand<Pacient>(acBLL.DeletePacient);
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
