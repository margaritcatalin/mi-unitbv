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
    class PacientBLL
    {
        public ObservableCollection<Pacient> PacientList { get; set; }
        public ObservableCollection<Pacient> PacientMedicList { get; set; }
        public PacientBLL()
        {
            PacientList = new ObservableCollection<Pacient>();
            PacientMedicList = new ObservableCollection<Pacient>();
        }
        internal ObservableCollection<Pacient> GetAllPacient()
        {
            PacientList.Clear();
            PacientDAL pretDAL = new PacientDAL();
            return pretDAL.GetAllPacients();
        }
        internal ObservableCollection<Pacient> GetAllPacientMedic(int? idMedic)
        {
            PacientMedicList.Clear();
            PacientDAL pretDAL = new PacientDAL();
            return pretDAL.GetAllPacientsMedic(idMedic);
        }
        internal int? GetCheltuieli(int? idMedic,int? idPacient)
        {
            PacientDAL persoaneDAL = new PacientDAL();
            return persoaneDAL.GetCheltuieli(idMedic,idPacient);
        }
        internal void AddPacient(Pacient pacient)
        {
            if (String.IsNullOrEmpty(pacient.Nume))
            {
                throw new ClinicException("Trebuie sa specificati numele pacientului");
            }
            PacientDAL pacientDAL = new PacientDAL();
            pacientDAL.AddPacient(pacient);
            PacientList.Add(pacient);
            PacientMedicList.Add(pacient);
        }
        internal void ModifyPacient(Pacient pacient)
        {
            if (pacient == null)
            {
                throw new ClinicException("Trebuie selectat un pacient");
            }
            if (String.IsNullOrEmpty(pacient.Nume))
            {
                throw new ClinicException("Trebuie sa specificati numele pacientului");
            }
            PacientDAL pacientDAL = new PacientDAL();
            pacientDAL.ModifyPacient(pacient);
        }

        internal void DeletePacient(Pacient pacient)
        {
            if (pacient == null)
            {
                throw new ClinicException("Trebuie precizat un pacient!");
            }
            PacientDAL pacientDAL = new PacientDAL();
            pacientDAL.DeletePacient(pacient);
            PacientList.Remove(pacient);
            PacientMedicList.Remove(pacient);
        }
    }
}
