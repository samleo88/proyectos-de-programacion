using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tienda.Entidades
{
    public class Vendedor
    {

        int _Idvendedor;
        string _Nombre;
        string _Apellidos;
        string _Sexo;
        string _Tipo_Documento;
        string _Num_Documento;
        string _Direccion;
        string _Telefono;
        string _Email;
        string _Acceso;
        string _Usuario;
        string _Password;
        //Propiedades Métodos Set y Get

        public int Idvendedor
        {
            get { return _Idvendedor; }
            set { _Idvendedor = value; }
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

        public string Acceso
        {
            get { return _Acceso; }
            set { _Acceso = value; }
        }

        public string Usuario
        {
            get { return _Usuario; }
            set { _Usuario = value; }
        }

        public string Password
        {
            get { return _Password; }
            set { _Password = value; }
        }

        //Constructores

        public Vendedor(int idvendedor, string nombre, string apellidos, string sexo,
             string tipo_documento, string num_documento, string direccion,
            string telefono, string email, string acceso, string usuario, string password)
        {
            this.Idvendedor = idvendedor;
            this.Nombre = nombre;
            this.Apellidos = apellidos;
            this.Sexo = sexo;
            this.Tipo_Documento = tipo_documento;
            this.Num_Documento = num_documento;
            this.Direccion = direccion;
            this.Telefono = telefono;
            this.Email = email;
            this.Acceso = acceso;
            this.Usuario = usuario;
            this.Password = password;



        }



        public Vendedor(int idcliente, string nombre, string apellidos, string sexo, string tipo_documento, string num_documento, string direccion, string telefono, string email, bool acceso, string usuario, string password) :
            this(0, "", "", "", "", "", "", "", "", "", usuario, password)
        {
        }

        public Vendedor(int idvendedor) : this(idvendedor, "", "", "", "", "", "", "", "","", "", "")
        {
        }

        public Vendedor(string nombre) : this(0, nombre, "", "", "", "", "", "", "", "", "", "")
        {
        }
        public Vendedor(string nombre, string apellido) : this(0, nombre, apellido, "", "", "", "", "", "", "", "", "")
        {
        }
        public Vendedor(int idcliente, string num_documento) : this(0, "", "", "", "", num_documento, "", "", "", "", "", "")
        {
        }

        public Vendedor() : this(0, "", "", "", "", "", "", "", "", "", "", "")
        {
        }

    }

}
