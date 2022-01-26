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
    public class InterventieViewModel : BaseViewModel
    {
        InterventieBLL intBLL = new InterventieBLL();
        AccountBLL acBLL = new AccountBLL();
        PretBLL pretBLL = new PretBLL();
        public Account Doctor { get; set; }
        public InterventieViewModel()
        {
            PretLists = pretBLL.GetAllPretCombo();
            DoctorList = acBLL.GetAllDoctors();
            Doctor = DashBoardMedic.user;
            if (Doctor != null)
                InterventiiMedicList = intBLL.GetInterventiiDoctor(DashBoardMedic.user);
            else
                InterventiiList = intBLL.GetAllInterventii();
        }
        #region Data Members
        public ObservableCollection<Interventie> InterventiiList
        {
            get
            {
                return intBLL.InterventiiList;
            }
            set
            {
                intBLL.InterventiiList = value;
            }
        }
        private int doctorID;
        public int DoctorID
        {
            get
            {
                return doctorID;
            }
            set
            {
                doctorID = value;
                OnPropertyChanged("DoctorID");
            }
        }
        private int pretID;
        public int PretID
        {
            get
            {
                return pretID;
            }
            set
            {
                pretID = value;
                OnPropertyChanged("PretID");
            }
        }
        public ObservableCollection<Interventie> InterventiiMedicList
        {
            get
            {
                return intBLL.InterventiiDoctorList;
            }
            set
            {
                intBLL.InterventiiDoctorList = value;
            }
        }
        private ObservableCollection<Account> doctorList;
        public ObservableCollection<Account> DoctorList
        {
            get
            {
                return doctorList;
            }
            set
            {
                doctorList = value;
            }
        }
        private ObservableCollection<Pret> pretLists;
        public ObservableCollection<Pret> PretLists
        {
            get
            {
                return pretLists;
            }
            set
            {
                pretLists = value;
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
                    addCommand = new RelayCommand<Interventie>(intBLL.AddInterventie);
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
                    updateCommand = new RelayCommand<Interventie>(intBLL.ModifyInterventie);
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
                    deleteCommand = new RelayCommand<Interventie>(intBLL.DeleteInterventie);
                }
                return deleteCommand;
            }
            set
            {
                deleteCommand = value;
            }
        }

        private ICommand changeAccountCommand;
        public ICommand ChangeAccountCommand
        {
            get
            {
                if (changeAccountCommand == null)
                {
                    changeAccountCommand = new RelayCommand<Account>(intBLL.GetInterventiiForDoctor);
                }
                return changeAccountCommand;
            }
            set
            {
                changeAccountCommand = value;
            }
        }
        private ICommand changePretCommand;
        public ICommand ChangePretCommand
        {
            get
            {
                if (changePretCommand == null)
                {
                    changePretCommand = new RelayCommand<Pret>(intBLL.GetInterventiiForPret);
                }
                return changePretCommand;
            }
            set
            {
                changePretCommand = value;
            }
        }
        #endregion
    }
}
