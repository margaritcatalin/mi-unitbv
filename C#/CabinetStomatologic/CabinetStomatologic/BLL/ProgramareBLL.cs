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
    class ProgramareBLL
    {
        public ObservableCollection<Programare> ProgramareList { get; set; }
        public ObservableCollection<Programare> ProgramareMedicList { get; set; }
        public ProgramareBLL()
        {
            ProgramareList = new ObservableCollection<Programare>();
            ProgramareMedicList = new ObservableCollection<Programare>();
        }
        internal ObservableCollection<Programare> GetAllProgramari()
        {
            ProgramareList.Clear();
            ProgramareDAL dal = new ProgramareDAL();
            return dal.GetAllProgramari();
        }
        internal Interventie GetInterventie(int? idMedic)
        {
            ProgramareDAL persoaneDAL = new ProgramareDAL();
            Interventie ac = new Interventie();
            ac = persoaneDAL.GetInterventie(idMedic);
            return ac;
        }
        internal Pacient GetPacient(int? idMedic)
        {
            ProgramareDAL persoaneDAL = new ProgramareDAL();
            Pacient ac = new Pacient();
            ac = persoaneDAL.GetPacient(idMedic);
            return ac;
        }
        internal ObservableCollection<Programare> GetProgramariDoctor(Account persoana)
        {
            ProgramareMedicList.Clear();
            ProgramareDAL dal = new ProgramareDAL();
            return dal.GetAllProgramariDoctor(persoana);
        }
        internal void GetProgramariForPerson(Pacient persoana)
        {
            ProgramareMedicList.Clear();
            ProgramareDAL telefoaneDAL = new ProgramareDAL();
            var phones = telefoaneDAL.GetProgramariForPerson(persoana);
            foreach (var ph in phones)
            {
                ProgramareMedicList.Add(ph);
            }
        }
        internal void AddProgramare(Programare programare)
        {
            if (programare.DataProgramare == null)
            {
                throw new ClinicException("Precizati data programarii");

            }
            else if (programare.PacientID == null)
            {
                throw new ClinicException("Trebuie precizat pacientul");
            }
            else if (programare.InterventieID == null)
            {
                throw new ClinicException("Trebuie precizata interventia");
            }
            else
            {
                ProgramareDAL dal = new ProgramareDAL();
                dal.AddProgramare(programare);
                ProgramareList.Add(programare);
                ProgramareMedicList.Add(programare);
            }
        }

        internal void ModifyProgramare(Programare programare)
        {
            if (programare == null)
            {
                throw new ClinicException("Trebuie selectata o programare");
            }
            else if (programare.PacientID == null)
            {
                throw new ClinicException("Trebuie precizat pacientul");
            }
            else if (programare.InterventieID == null)
            {
                throw new ClinicException("Trebuie precizata interventia");
            }
            ProgramareDAL dal = new ProgramareDAL();
            dal.ModityProgramare(programare);
        }
        /*    internal ObservableCollection<Programare> GetProgramareForInterventie(Interventie persoana)
     {
         ProgramareDAL telefoaneDAL = new ProgramareDAL();
         return telefoaneDAL.GetProgramareForInterventie(persoana);
     }
      internal ObservableCollection<Programare> GetProgramareForPacient(Pacient persoana)
     {
         ProgramareDAL telefoaneDAL = new ProgramareDAL();
         return telefoaneDAL.GetProgramareForPacient(persoana);
     }*/
        internal void DeleteProgramare(Programare programare)
        {
            if (programare == null || programare.ProgramareID == null)
            {
                throw new ClinicException("Alege o programare!");
            }
            ProgramareDAL dal = new ProgramareDAL();
            dal.DeleteProgramare(programare);
            ProgramareList.Remove(programare);
            ProgramareMedicList.Remove(programare);
        }
    }
}
