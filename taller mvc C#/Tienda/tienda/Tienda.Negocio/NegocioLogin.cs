using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;
using Tienda.Entidades;
using Tienda.Datos;


namespace Tienda.Negocio
{
   public class NegocioLogin
    {
        DatosLogin objDatos = new DatosLogin();
        public DataTable LogonN(EntidadLogin e)
        {
            return objDatos.Login(e);
        }
    }
}
