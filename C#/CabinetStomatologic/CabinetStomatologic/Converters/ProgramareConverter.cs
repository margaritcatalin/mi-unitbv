using CabinetStomatologic.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Data;

namespace CabinetStomatologic.Converters
{
    class ProgramareConverter : IMultiValueConverter
    {
        public object Convert(object[] values, Type targetType, object parameter, System.Globalization.CultureInfo culture)
        {
            int pacientID;
            if (!int.TryParse(values[0].ToString(), out pacientID))
            {
                return null;
            }
            int interventieID;
            if (!int.TryParse(values[1].ToString(), out interventieID))
            {
                return null;
            }
            DateTime data;
            if (!DateTime.TryParse(values[2].ToString(), out data))
            {
                return null;
            }
            return new Programare()
            {
                PacientID = pacientID,
                InterventieID = interventieID,
                DataProgramare = data
            };
        }
        public object[] ConvertBack(object value, Type[] targetTypes, object parameter, System.Globalization.CultureInfo culture)
        {
            Programare programare = value as Programare;
            object[] result = new object[3] { programare.PacientID, programare.InterventieID, programare.DataProgramare };
            return result;
        }
    }
}
