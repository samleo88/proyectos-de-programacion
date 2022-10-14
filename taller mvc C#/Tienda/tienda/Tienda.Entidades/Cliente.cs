using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tienda.Entidades
{
   public class Cliente
    {
       int _Idcliente;
       string _Nombre;
       string _Apellidos;
       string _Sexo;
       string _Tipo_Documento;
       string _Num_Documento;
       string _Direccion;
       string _Telefono;
       string _Email;
        //Propiedades Métodos Set y Get

        public int Idcliente
        {
            get { return _Idcliente; }
            set { _Idcliente = value; }
        }

        public string Nombre
        {
            get { return _Nombre; }
            set { _Nombre = value; }
        }

        public string Apellidos
        {
            get { return _Apellidos; }
            set { _Apellidos = value; }
        }

        public string Sexo
        {
            get { return _Sexo; }
            set { _Sexo = value; }
        }



        public string Tipo_Documento
        {
            get { return _Tipo_Documento; }
            set { _Tipo_Documento = value; }
        }
        public string Num_Documento
        {
            get { return _Num_Documento; }
            set { _Num_Documento = value; }
        }

        public string Direccion
        {
            get { return _Direccion; }
            set { _Direccion = value; }
        }

        public string Telefono
        {
            get { return _Telefono; }
            set { _Telefono = value; }
        }

        public string Email
        {
            get { return _Email; }
            set { _Email = value; }
        }



        //Constructores

        public Cliente(int idcliente, string nombre, string apellidos, string sexo,
             string tipo_documento, string num_documento, string direccion,
            string telefono, string email)
        {
            this.Idcliente = idcliente;
            this.Nombre = nombre;
            this.Apellidos = apellidos;
            this.Sexo = sexo;
            this.Tipo_Documento = tipo_documento;
            this.Num_Documento = num_documento;
            this.Direccion = direccion;
            this.Telefono = telefono;
            this.Email = email;


        }

       

        public Cliente(int idcliente, string nombre, string apellidos, string sexo, string tipo_documento, string num_documento, string direccion, string telefono, string email, string textobuscar) : 
            this( idcliente,  nombre,  apellidos,  "",tipo_documento,  num_documento,  "", telefono, "")
        {
        }

        public Cliente(int idcliente) : this(idcliente, "", "", "", "", "", "", "", "")
        {
        }

        public Cliente(string nombre) : this(0, nombre, "", "", "", "", "", "", "")
        {
        }
        public Cliente(string nombre, string apellido) : this(0, nombre, apellido, "", "", "", "", "", "")
        {
        }
        public Cliente (int idcliente,string num_documento) : this( 0, "","", "","",num_documento,"","","" )
        {
        }

        public Cliente() : this(0, "", "", "","","","","","","")
        {
        }





    }
}
