using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tienda.Entidades
{
   public class EntidadLogin
    {
        public string Acceso { get; set; }
        public string Usuario { get; set; }
        public string Password { get; set; }
        //Constructores

        public EntidadLogin( string acceso, string usuario, string password)
        {
           
            this.Acceso = acceso;
            this.Usuario = usuario;
            this.Password = password;

        }
        public EntidadLogin(string Acceso) : this(Acceso, "", "")
        {
        }

        public EntidadLogin()        {
        }
        
    }
}
