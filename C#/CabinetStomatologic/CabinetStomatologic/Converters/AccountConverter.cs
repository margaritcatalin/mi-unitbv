using CabinetStomatologic.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Data;

namespace CabinetStomatologic.Converters
{
    class AccountConverter : IMultiValueConverter
    {
        public object Convert(object[] values, Type targetType, object parameter, System.Globalization.CultureInfo culture)
        {
            if (values[0] != null && values[1] != null && values[2] != null && values[3] != null)
            {
                return new Account()
                {
                    Username = values[0].ToString(),
                    Password = values[1].ToString(),
                    Name = values[2].ToString(),
                    Role = values[3].ToString()
                };
            }
            else
            {
                return null;
            }
        }
        public object[] ConvertBack(object value, Type[] targetTypes, object parameter, System.Globalization.CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }
}
