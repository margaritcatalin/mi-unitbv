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
    class InterventieBLL
    {
        public ObservableCollection<Interventie> InterventiiList { get; set; }
        public ObservableCollection<Interventie> InterventiiDoctorList { get; set; }
        public InterventieBLL()
        {
            InterventiiList = new ObservableCollection<Interventie>();
            InterventiiDoctorList = new ObservableCollection<Interventie>();
        }
        internal void GetInterventiiForDoctor(Account persoana)
        {
            InterventiiList.Clear();
            InterventieDAL telefoaneDAL = new InterventieDAL();
            var phones = telefoaneDAL.GetInterventiiForDoctor(persoana);
            foreach (var ph in phones)
            {
                InterventiiDoctorList.Add(ph);
            }
        }
        internal void GetInterventiiForPret(Pret persoana)
        {
            InterventiiList.Clear();
            InterventieDAL telefoaneDAL = new InterventieDAL();
            var phones = telefoaneDAL.GetInterventiiForPret(persoana);
            foreach (var ph in phones)
            {
                InterventiiDoctorList.Add(ph);
            }
        }
        internal ObservableCollection<Interventie> GetAllInterventii()
        {
            InterventiiList.Clear();
            InterventieDAL interventieDAL = new InterventieDAL();
            return interventieDAL.GetAllInterventii();
        }
        internal Account GetDoctor(int? idMedic)
        {
            InterventieDAL persoaneDAL = new InterventieDAL();
            Account ac = new Account();
            ac = persoaneDAL.GetDoctor(idMedic);
            return ac;
        }
        internal Pret GetPret(int? idMedic)
        {
            InterventieDAL persoaneDAL = new InterventieDAL();
            Pret ac = new Pret();
            ac = persoaneDAL.GetPret(idMedic);
            return ac;
        }
        internal ObservableCollection<Interventie> GetInterventiiDoctor(Account persoana)
        {
            InterventiiDoctorList.Clear();
            InterventieDAL interventieDAL = new InterventieDAL();
            return interventieDAL.GetAllInterventiiDoctor(persoana);
        }
        internal void AddInterventie(Interventie interventie)
        {
            if (String.IsNullOrEmpty(interventie.Denumire))
            {
                throw new ClinicException("Denumirea trebuie precizata");

            }
            else if (interventie.DoctorID == null)
            {
                throw new ClinicException("Trebuie precizat cui ii apartine interventia");
            }
            else if (interventie.PretID == null)
            {
                throw new ClinicException("Trebuie precizat pretul interventiei");
            }
            else
            {
                InterventieDAL interventieDAL = new InterventieDAL();
                interventieDAL.AddInterventie(interventie);
                InterventiiList.Add(interventie);
                InterventiiDoctorList.Add(interventie);
            }
        }

        internal void ModifyInterventie(Interventie interventie)
        {
            if (interventie == null)
            {
                throw new ClinicException("Trebuie selectata o interventie");
            }
            if (String.IsNullOrEmpty(interventie.Denumire))
            {
                throw new ClinicException("Denumirea trebuie precizata");

            }
            else if (interventie.DoctorID == null)
            {
                throw new ClinicException("Trebuie precizat cui ii apartine interventia");
            }
            else if (interventie.PretID == null)
            {
                throw new ClinicException("Trebuie precizat pretul interventiei");
            }
            InterventieDAL interventieDAL = new InterventieDAL();
            interventieDAL.ModifyInterventie(interventie);
        }

        internal void DeleteInterventie(Interventie interventie)
        {
            if (interventie == null || interventie.InterventieID == null)
            {
                throw new ClinicException("Alege o interventie!");
            }
            InterventieDAL interventieDAL = new InterventieDAL();
            interventieDAL.DeleteInterventie(interventie);
            InterventiiList.Remove(interventie);
            InterventiiDoctorList.Remove(interventie);
        }
    }
}
