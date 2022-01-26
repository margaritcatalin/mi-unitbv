using CabinetStomatologic.BLL;
using CabinetStomatologic.Views;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CabinetStomatologic.Models
{
    public class Pacient : BasePropertyChanged
    {
        private int? pacientID;
        public int? PacientID
        {
            get
            {
                return pacientID;
            }
            set
            {
                pacientID = value;
                NotifyPropertyChanged("PacientID");
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
        private string nume;
        public string Nume
        {
            get
            {
                return nume;
            }
            set
            {
                nume = value;
                NotifyPropertyChanged("Nume");
            }
        }
        public int? Cheltuieli
        {
            get
            {
                PacientBLL intBLL = new PacientBLL();
                return intBLL.GetCheltuieli(DashBoardMedic.user.AccountID, PacientID);
            }
        }
    }
}
