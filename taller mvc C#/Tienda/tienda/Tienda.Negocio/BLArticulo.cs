using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Tienda.Entidades;
using Tienda.Datos;
using System.Data;

namespace Tienda.Negocio
{
   public class BLArticulo
    {
        public List<Articulo> Listar()
        {
            DAOArticulo daArticulo = new DAOArticulo();
            return daArticulo.Listar();
        }

        public Articulo TraerPorId(int Id)
        {
            DAOArticulo daArticulo = new DAOArticulo();
            return daArticulo.TraerPorId(Id);
        }

        public int Insertar(Articulo articulo)
        {
            DAOArticulo daArticulo = new DAOArticulo();
            return daArticulo.Insertar(articulo);
        }

        public int Actualizar(Articulo articulo)
        {
            DAOArticulo daArticulo = new DAOArticulo();
            return daArticulo.Actualizar(articulo);
        }

        public int Eliminar(int Id)
        {
            DAOArticulo daArticulo = new DAOArticulo();
            return daArticulo.Eliminar(Id);
        }
    }
}
