using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;
using Tienda.Entidades;

namespace Tienda.Datos
{
   public class DatosLogin
    {
        readonly SqlConnection cn = new SqlConnection(DBcommon.Conex);
        public DataTable Login(EntidadLogin e)
        {
            using (SqlCommand cmd = new SqlCommand("splogin", cn))
            {
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@usuario", e.Usuario);
                cmd.Parameters.AddWithValue("@password", e.Password);
                using (SqlDataAdapter da = new SqlDataAdapter(cmd))
                {
                    DataTable tbl = new DataTable();
                    da.Fill(tbl);
                    return tbl;
                }
            }
        }
    }
}
