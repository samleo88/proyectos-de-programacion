using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;

namespace Tienda.Datos
{
   public  class DBcommon
    {
        public static string Conex = @"Data Source =.; Initial Catalog = Tienda; Integrated Security = True";
        public static IDbConnection Conexion() {
            return new SqlConnection(Conex);
        }

        public static IDbCommand ObtenerComando(string pComando, IDbConnection pCnn) {
            return new SqlCommand(pComando, pCnn as SqlConnection);
        }
    }
}
