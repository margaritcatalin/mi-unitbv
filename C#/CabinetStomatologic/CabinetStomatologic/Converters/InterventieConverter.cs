using CabinetStomatologic.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Data;

namespace CabinetStomatologic.Converters
{
    class InterventieConverter : IMultiValueConverter
    {
        public object Convert(object[] values, Type targetType, object parameter, System.Globalization.CultureInfo culture)
        {
            int doctorId;
            if (!int.TryParse(values[0].ToString(), out doctorId))
            {
                return null;
            }
            int pretId;
            if (!int.TryParse(values[1].ToString(), out pretId))
            {
                return null;
            }
            return new Interventie()
            {
                DoctorID = doctorId,
                PretID = pretId,
                Denumire = values[2].ToString()
            };
        }
        public object[] ConvertBack(object value, Type[] targetTypes, object parameter, System.Globalization.CultureInfo culture)
        {
            Interventie interventie = value as Interventie;
            object[] result = new object[3] { interventie.DoctorID, interventie.PretID, interventie.Denumire };
            return result;
        }
    }
}

