using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Tienda.Entidades;
using Tienda.Datos;


namespace Tienda.Negocio
{
   public class BLCliente
    {
        public List<Cliente> Listar()
        {
            DAOCliente daCliente = new DAOCliente();
            return daCliente.Listar();
        }

        public Cliente TraerPorId(int Id)
        {
            DAOCliente daCliente = new DAOCliente();
            return daCliente.TraerPorId(Id);
        }

        public int Insertar(Cliente cliente)
        {
            DAOCliente daCliente = new DAOCliente();
            return daCliente.Insertar(cliente);
        }

        public int Actualizar(Cliente cliente)
        {
            DAOCliente daCliente = new DAOCliente();
            return daCliente.Actualizar(cliente);
        }

        public int Eliminar(int Id)
        {
            DAOCliente daCliente = new DAOCliente();
            return daCliente.Eliminar(Id);
        }
    }
}
