using CabinetStomatologic.BLL;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CabinetStomatologic.Models
{
    public class Programare : BasePropertyChanged
    {
        private int? idProgramare;
        public int? ProgramareID
        {
            get
            {
                return idProgramare;
            }
            set
            {
                idProgramare = value;
                NotifyPropertyChanged("ProgramareID");
            }
        }
        private bool? sters;
        public bool? Sters
        {
            get
            {
                return sters;
            }
            set
            {
                sters = value;
                NotifyPropertyChanged("Sters");
            }
        }
        private int? idPacient;
        public int? PacientID
        {
            get
            {
                return idPacient;
            }
            set
            {
                idPacient = value;
                NotifyPropertyChanged("PacientID");
            }
        }
        private int? idInterventie;
        public int? InterventieID
        {
            get
            {
                return idInterventie;
            }
            set
            {
                idInterventie = value;
                NotifyPropertyChanged("InterventieID");
            }
        }
        
        private DateTime dataProgramare;
        public DateTime DataProgramare
        {
            get
            {
                return dataProgramare;
            }
            set
            {
                dataProgramare = value;
                NotifyPropertyChanged("DataProgramare");
            }
        }
        public Pacient Pacient
        {
            get
            {
                ProgramareBLL intBLL = new ProgramareBLL();
                return intBLL.GetPacient(PacientID);
            }
        }
        public Interventie Interventie
        {
            get
            {
                ProgramareBLL intBLL = new ProgramareBLL();
                return intBLL.GetInterventie(InterventieID);
            }
        }
    }
}
