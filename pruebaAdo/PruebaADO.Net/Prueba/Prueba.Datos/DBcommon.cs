using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;

namespace Prueba.Datos
{
   public class DBcommon
    {
        public static string Conex = @"Data Source=LAPTOP-36OD0Q3O\MSSQLSERVER01;Initial Catalog=Prueba;Integrated Security=True";
        public static IDbConnection Conexion()
        {
            return new SqlConnection(Conex);
        }

        public static IDbCommand ObtenerComando(string pComando, IDbConnection pCnn)
        {
            return new SqlCommand(pComando, pCnn as SqlConnection);
        }
    }
}
