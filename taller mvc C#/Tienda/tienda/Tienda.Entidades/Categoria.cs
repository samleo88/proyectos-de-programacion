using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tienda.Entidades
{
    public class Categoria
    {
        // Atributos  de la clase Categoria
        int _id;
        string _codigo;
        string _nombre;
        string _descripcion;

        // Se definen los metodos get y set
        public int Id
        {
            get { return _id; }
            set { _id = value; }
        }


        public string Codigo
        {
            get { return _codigo; }
            set { _codigo = value; }
        }

        public string Nombre
        {
            get { return _nombre; }
            set { _nombre = value; }
        }

        public string Descripcion
        {
            get { return _descripcion; }
            set { _descripcion = value; }
        }

        public Categoria(int Id, string Codigo, string Nombre, string Descripcion)
        {
            this._id = Id;
            this._codigo = Codigo;
            this._nombre = Nombre;
            this._descripcion = Descripcion;
        }

        public Categoria(int Id, string Codigo, string Nombre) : this(Id, Codigo, Nombre, "")
        {
        }

        public Categoria(int Id, string Nombre) : this(Id, "", Nombre, "")
        {
        }

        public Categoria() : this(0, "", "", "")
        {
        }

        
    }


}
