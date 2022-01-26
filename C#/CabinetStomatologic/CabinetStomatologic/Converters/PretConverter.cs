using CabinetStomatologic.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Data;

namespace CabinetStomatologic.Converters
{
    class PretConverter : IMultiValueConverter
    {
        public object Convert(object[] values, Type targetType, object parameter, System.Globalization.CultureInfo culture)
        {
            DateTime dataInceput;
            DateTime dataFinala;
            int valoare;
            if (!DateTime.TryParse(values[1].ToString(), out dataInceput))
            {
                return null;
            }
            if (!DateTime.TryParse(values[2].ToString(), out dataFinala))
            {
                return null;
            }
            if (!int.TryParse(values[0].ToString(), out valoare))
            {
                return null;
            }
            return new Pret()
            {
                Valoare = valoare,
                DataInceput = dataInceput,
                DataFinal = dataFinala
            };
        }
        public object[] ConvertBack(object value, Type[] targetTypes, object parameter, System.Globalization.CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }
}
