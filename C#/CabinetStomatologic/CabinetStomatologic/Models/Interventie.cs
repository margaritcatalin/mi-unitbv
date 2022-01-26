using CabinetStomatologic.BLL;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CabinetStomatologic.Models
{
    public class Interventie : BasePropertyChanged
    {
        private int? interventieID;
        public int? InterventieID
        {
            get
            {
                return interventieID;
            }
            set
            {
                interventieID = value;
                NotifyPropertyChanged("InterventieID");
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
        private int? accountID;
        public int? DoctorID
        {
            get
            {
                return accountID;
            }
            set
            {
                accountID = value;
                NotifyPropertyChanged("DoctorID");
            }
        }
        public Account Doctor
        {
            get
            {
                InterventieBLL intBLL = new InterventieBLL();
                return intBLL.GetDoctor(DoctorID);
            }
        }
        public Pret Pret
        {
            get
            {
                InterventieBLL intBLL = new InterventieBLL();
                return intBLL.GetPret(PretID);
            }
        }
        private int? pretID;
        public int? PretID
        {
            get
            {
                return pretID;
            }
            set
            {
                pretID = value;
                NotifyPropertyChanged("PretID");
            }
        }
        private string denumire;
        public string Denumire
        {
            get
            {
                return denumire;
            }
            set
            {
                denumire = value;
                NotifyPropertyChanged("Denumire");
            }
        }
    }
}
