using CabinetStomatologic.DAL;
using CabinetStomatologic.Exception;
using CabinetStomatologic.Models;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CabinetStomatologic.BLL
{
    class PretBLL
    {
        public ObservableCollection<Pret> PretList { get; set; }

        internal ObservableCollection<Pret> GetAllPret()
        {
            PretDAL pretDAL = new PretDAL();
            return pretDAL.GetAllPret();
        }
        internal ObservableCollection<Pret> GetAllPretCombo()
        {
            PretDAL pretDAL = new PretDAL();
            return pretDAL.GetAllPretCombo();
        }
        internal void AddPret(Pret pret)
        {
            if (pret.DataInceput==null|| pret.DataFinal == null)
            {
                throw new ClinicException("Trebuie sa specificati intervalul in care va fi valabil pretul");
            }
            if (pret.Valoare==0)
            {
                throw new ClinicException("Introduceti pretul");
            }
            PretDAL pretDAL = new PretDAL();
            pretDAL.AddPret(pret);
            PretList.Add(pret);
        }
        internal void ModifyPret(Pret pret)
        {
            if (pret == null)
            {
                throw new ClinicException("Trebuie selectat un pret");
            }
            if (pret.DataInceput == null || pret.DataFinal == null)
            {
                throw new ClinicException("Trebuie sa specificati intervalul in care va fi valabil pretul");
            }
            if (pret.Valoare == 0)
            {
                throw new ClinicException("Introduceti pretul");
            }
            PretDAL pretDAL = new PretDAL();
            pretDAL.ModityPret(pret);
        }

        internal void DeletePret(Pret pret)
        {
            if (pret == null)
            {
                throw new ClinicException("Trebuie precizat un pret!");
            }
            PretDAL pretDAL = new PretDAL();
            pretDAL.DeletePret(pret);
            PretList.Remove(pret);
        }
    }
}
