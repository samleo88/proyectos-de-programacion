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
    public class BLVendedor
    {
        public List<Vendedor> Listar()
        {
            DAOVendedor daVendedor = new DAOVendedor();
            return daVendedor.Listar();
        }

        public Vendedor TraerPorId(int Id)
        {
            DAOVendedor daVendedor = new DAOVendedor();
            return daVendedor.TraerPorId(Id);
        }

        public int Insertar(Vendedor vendedor)
        {
            DAOVendedor daVendedor = new DAOVendedor();
            return daVendedor.Insertar(vendedor);
        }

        public int Actualizar(Vendedor vendedor)
        {
            DAOVendedor daVendedor = new DAOVendedor();
            return daVendedor.Actualizar(vendedor);
        }

        public int Eliminar(int Id)
        {
            DAOVendedor daVendedor = new DAOVendedor();
            return daVendedor.Eliminar(Id);
        }
     

    }
}
