using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Prueba.Entidades
{
  public  class Cliente
    {
        int _Idcliente;
        string _Nombre;
        string _Apellidos;
        string _Direccion;

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

        public string Direccion
        {
            get { return _Direccion; }
            set { _Direccion = value; }
        }


        public Cliente(int idcliente, string nombre, string apellidos, string direccion )
        {
            this.Idcliente = idcliente;
            this.Nombre = nombre;
            this.Apellidos = apellidos;
            this.Direccion = direccion;



        }



        public Cliente(int idcliente, string nombre, string apellidos, string direccion, string textobuscar) :
            this(idcliente, nombre, apellidos, "")
        {
        }

        public Cliente(int idcliente) : this(idcliente, "", "", "")
        {
        }

        public Cliente(string nombre) : this(0, nombre, "", "")
        {
        }
        public Cliente(string nombre, string apellido) : this(0, nombre, apellido, "", "")
        {
        }
        public Cliente(int idcliente, string direccion) : this(0, "", "", "", direccion)
        {
        }

        public Cliente() : this(0, "", "", "")
        {
        }



    }
}
