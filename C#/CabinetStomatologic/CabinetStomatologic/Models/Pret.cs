using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CabinetStomatologic.Models
{
    public class Pret : BasePropertyChanged
    {
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
        private int valoare;
        public int Valoare
        {
            get
            {
                return valoare;
            }
            set
            {
                valoare = value;
                NotifyPropertyChanged("Valoare");
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

        private DateTime dataInceput;
        public DateTime DataInceput
        {
            get
            {
                return dataInceput;
            }
            set
            {
                dataInceput = value;
                NotifyPropertyChanged("DataInceput");
            }
        }
        private DateTime dataFinal;
        public DateTime DataFinal
        {
            get
            {
                return dataFinal;
            }
            set
            {
                dataFinal = value;
                NotifyPropertyChanged("DataFinal");
            }
        }

    }
}
