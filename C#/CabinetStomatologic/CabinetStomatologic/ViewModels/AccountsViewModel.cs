using CabinetStomatologic.BLL;
using CabinetStomatologic.Models;
using CabinetStomatologic.Utils;
using CabinetStomatologic.Views;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;
namespace CabinetStomatologic.ViewModels
{
    public class AccountsViewModel : BaseViewModel
    {
        AccountBLL acBLL = new AccountBLL();
        public AccountsViewModel()
        {
            AccountsList = acBLL.GetAllAccount();
        }
        #region Data Members
        public ObservableCollection<Account> AccountsList
        {
            get
            {
                return acBLL.AccountsList;
            }
            set
            {
                acBLL.AccountsList = value;
            }
        }
        #endregion
        #region ICommand Members

        private ICommand addCommand;
        public ICommand AddCommand
        {
            get
            {
                if (addCommand == null)
                {
                    addCommand = new RelayCommand<Account>(acBLL.AddAccount);
                }
                return addCommand;
            }
            set
            {
                addCommand = value;
            }
        }

        private ICommand updateCommand;
        public ICommand UpdateCommand
        {
            get
            {
                if (updateCommand == null)
                {
                    updateCommand = new RelayCommand<Account>(acBLL.ModifyAccount);
                }
                return updateCommand;
            }
            set
            {
                updateCommand = value;
            }
        }

        private ICommand deleteCommand;
        public ICommand DeleteCommand
        {
            get
            {
                if (deleteCommand == null)
                {
                    deleteCommand = new RelayCommand<Account>(acBLL.DeleteAccount);
                }
                return deleteCommand;
            }
            set
            {
                deleteCommand = value;
            }
        }
        #endregion

    }
}
