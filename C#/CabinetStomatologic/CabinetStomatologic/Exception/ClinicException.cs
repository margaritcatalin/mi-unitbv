using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CabinetStomatologic.Exception
{
    class ClinicException : ApplicationException
    {
        public ClinicException(string message)
            : base(message)
        {
        }
    }
}
