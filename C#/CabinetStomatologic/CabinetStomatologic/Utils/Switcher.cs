using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace CabinetStomatologic.Utils
{
    class Switcher
    {
        public static MainWindow stacktest;
        public static void Switch(UserControl newPage)
        {
            stacktest.Navigate(newPage);
        }
    }
}
