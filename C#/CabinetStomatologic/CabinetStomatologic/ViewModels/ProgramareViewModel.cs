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
    public class ProgramareViewModel : BaseViewModel
    {
        ProgramareBLL acBLL = new ProgramareBLL();
        PacientBLL pacientBLL = new PacientBLL();
        InterventieBLL intBLL=new InterventieBLL();
        public DateTime DataProgramareDatePicker { get; set; }
        public ProgramareViewModel()
        {
            PacientList = pacientBLL.GetAllPacient();
            if (DashBoardMedic.user != null)
            {
                InterventieList = intBLL.GetInterventiiDoctor(DashBoardMedic.user);
                ProgramareListMedic = acBLL.GetProgramariDoctor(DashBoardMedic.user);
            }
            else
            {
                InterventieList = intBLL.GetAllInterventii();
                ProgramareList = acBLL.GetAllProgramari();
            }
            DataProgramareDatePicker = DateTime.Now;
        }
        #region Data Members
        public ObservableCollection<Programare> ProgramareList
        {
            get
            {
                return acBLL.ProgramareList;
            }
            set
            {
                acBLL.ProgramareList = value;
            }
        }
        public ObservableCollection<Programare> ProgramareListMedic
        {
            get
            {
                return acBLL.ProgramareMedicList;
            }
            set
            {
                acBLL.ProgramareMedicList = value;
            }
        }
        private ObservableCollection<Pacient> pacientList;
        public ObservableCollection<Pacient> PacientList
        {
            get
            {
                return pacientList;
            }
            set
            {
                pacientList = value;
            }
        }
        private ObservableCollection<Interventie> interventieList;
        public ObservableCollection<Interventie> InterventieList
        {
            get
            {
                return interventieList;
            }
            set
            {
                interventieList = value;
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
                    addCommand = new RelayCommand<Programare>(acBLL.AddProgramare);
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
                    updateCommand = new RelayCommand<Programare>(acBLL.ModifyProgramare);
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
                    deleteCommand = new RelayCommand<Programare>(acBLL.DeleteProgramare);
                }
                return deleteCommand;
            }
            set
            {
                deleteCommand = value;
            }
        }
        private ICommand changeInterventiiCommand;
        public ICommand ChangeInterventiiCommand
        {
            get
            {
                if (changeInterventiiCommand == null)
                {
                   // changeInterventiiCommand = new RelayCommand<Interventie>(acBLL.GetProgramareForInterventie);
                }
                return changeInterventiiCommand;
            }
            set
            {
                changeInterventiiCommand = value;
            }
        }
        private ICommand changePacientCommand;
        public ICommand ChangePacientCommand
        {
            get
            {
                if (changePacientCommand == null)
                {
                //    changePacientCommand = new RelayCommand<Pacient>(acBLL.GetProgramareForPacient);
                }
                return changePacientCommand;
            }
            set
            {
                changePacientCommand = value;
            }
        }
        #endregion
    }
}
