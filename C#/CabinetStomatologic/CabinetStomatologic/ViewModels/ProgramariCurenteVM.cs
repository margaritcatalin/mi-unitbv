using CabinetStomatologic.BLL;
using CabinetStomatologic.Models;
using CabinetStomatologic.Views;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CabinetStomatologic.ViewModels
{
    public class ProgramariCurenteVM : BaseViewModel
    {
        public Dictionary<Pacient, ObservableCollection<Programare>> Programari { get; set; }
        public ProgramariCurenteVM()
        {
            PacientBLL personBLL = new PacientBLL();
            Programari = new Dictionary<Pacient, ObservableCollection<Programare>>();
            foreach (Pacient person in personBLL.GetAllPacientMedic(DashBoardMedic.user.AccountID))
            {
                ProgramareBLL phoneBLL = new ProgramareBLL();
                phoneBLL.GetProgramariForPerson(person);
                Programari.Add(person, phoneBLL.ProgramareMedicList);
            }
        }
    }
}
