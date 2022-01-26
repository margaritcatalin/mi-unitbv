using CabinetStomatologic.Utils;
using MaterialDesignThemes.Wpf;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace CabinetStomatologic.ViewModels
{
    public class HomeViewModel : BaseViewModel
    {
        private BaseViewModel content;
        public BaseViewModel Content
        {
            get { return content; }
            set
            {
                content = value;
            }
        }
        public Boolean IsLoading { get; set; }

        public HomeViewModel(BaseViewModel model)
        {
            content = model;
        }

        public void CloseRootDialog()
        {
            DialogHost.CloseDialogCommand.Execute("RootDialog", null);
        }
    }
}

