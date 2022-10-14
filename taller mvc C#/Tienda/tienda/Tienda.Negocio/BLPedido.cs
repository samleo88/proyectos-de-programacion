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
   public class BLPedido
    {
        public List<Pedido> Listar()
        {
            DAOPedido daPedido = new DAOPedido();
            return daPedido.Listar();
        }

        public Pedido TraerPorId(int Id)
        {
            DAOPedido daPedido = new DAOPedido();
            return daPedido.TraerPorId(Id);
        }

        public int Insertar(Pedido pedido)
        {
            DAOPedido daPedido = new DAOPedido();
            return daPedido.Insertar(pedido);
        }

        public int Actualizar(Pedido pedido)
        {
            DAOPedido daPedido = new DAOPedido();
            return daPedido.Actualizar(pedido);
        }

        public int Eliminar(int Id)
        {
            DAOPedido daPedido = new DAOPedido();
            return daPedido.Eliminar(Id);
        }
    }
}
