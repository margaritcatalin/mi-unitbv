using CabinetStomatologic.BLL;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CabinetStomatologic.Models
{
    public class Account : BasePropertyChanged
    {
        private int? accountID;
        public int? AccountID
        {
            get
            {
                return accountID;
            }
            set
            {
                accountID = value;
                NotifyPropertyChanged("AccountID");
            }
        }
        public int? Venit
        {
            get
            {
                AccountBLL intBLL = new AccountBLL();
                return intBLL.GetVenitMedic(AccountID);
            }
        }
        private string name;
        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                name = value;
                NotifyPropertyChanged("Name");
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

        private string username;
        public string Username
        {
            get
            {
                return username;
            }
            set
            {
                username = value;
                NotifyPropertyChanged("Username");
            }
        }
        private string password;
        public string Password
        {
            get
            {
                return password;
            }
            set
            {
                password = value;
                NotifyPropertyChanged("Password");
            }
        }
        private string role;
        public string Role
        {
            get
            {
                return role;
            }
            set
            {
                role = value;
                NotifyPropertyChanged("Role");
            }
        }
    }
}
