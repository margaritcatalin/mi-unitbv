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
    class AccountBLL
    {
        public ObservableCollection<Account> AccountsList { get; set; }

        internal ObservableCollection<Account> GetAllAccount()
        {
            AccountDAL persoanaDAL = new AccountDAL();
            return persoanaDAL.GetAllAccount();
        }

        internal ObservableCollection<Account> GetAllDoctors()
        {
            AccountDAL persoaneDAL = new AccountDAL();
            return persoaneDAL.GetAllDoctors();
        }

        internal void AddAccount(Account persoana)
        {
            if (String.IsNullOrEmpty(persoana.Username))
            {
                throw new ClinicException("Username este camp obligatoriu");
            }
            if (String.IsNullOrEmpty(persoana.Password))
            {
                throw new ClinicException("Parola este camp obligatoriu");
            }
            if (String.IsNullOrEmpty(persoana.Role))
            {
                throw new ClinicException("Rolul este camp obligatoriu");
            }
            if (String.IsNullOrEmpty(persoana.Name))
            {
                throw new ClinicException("Numele este camp obligatoriu");
            }
            AccountDAL persoaneDAL = new AccountDAL();
            persoaneDAL.AddAccount(persoana);
            AccountsList.Add(persoana);
        }
        internal Account GetAccount(string username, string password)
        {
            if (String.IsNullOrEmpty(username))
            {
                throw new ClinicException("Username este camp obligatoriu");
            }
            if (String.IsNullOrEmpty(password))
            {
                throw new ClinicException("Parola este camp obligatoriu");
            }
            AccountDAL persoaneDAL = new AccountDAL();
            Account ac = new Account();
            ac=persoaneDAL.GetAccount(username,password);
            return ac;
        }
        internal int? GetVenitMedic(int? idMedic)
        {
            AccountDAL persoaneDAL = new AccountDAL();
            return persoaneDAL.GetVenitMedic(idMedic);
        }
        internal void ModifyAccount(Account persoana)
        {
            if (persoana == null)
            {
                throw new ClinicException("Trebuie selectata o persoana");
            }
            if (String.IsNullOrEmpty(persoana.Name))
            {
                throw new ClinicException("Trebuie precizat numele persoanei");
            }
            AccountDAL persoaneDAL = new AccountDAL();
            persoaneDAL.ModifyAccount(persoana);
        }

        internal void DeleteAccount(Account persoana)
        {
            if (persoana == null)
            {
                throw new ClinicException("Trebuie precizata o persoana!");
            }
            else
            {
                AccountDAL phoneDAL = new AccountDAL();
            }
            AccountDAL persoanaDAL = new AccountDAL();
            persoanaDAL.DeleteAccount(persoana);
            AccountsList.Remove(persoana);
        }
    }
}
