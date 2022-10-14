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
   public class BLDetalle_pedido
    {
        public List<Detalle_pedido> Listar()
        {
            DAODetalle_pedido daDetalle_pedido = new DAODetalle_pedido();
            return daDetalle_pedido.Listar();
        }

        public Detalle_pedido TraerPorId(int Id)
        {
            DAODetalle_pedido daDetalle_pedido = new DAODetalle_pedido();
            return daDetalle_pedido.TraerPorId(Id);
        }
        public List<Detalle_pedido> listarID(int a)
        {
            DAODetalle_pedido daDetalle_pedido = new DAODetalle_pedido();
            return daDetalle_pedido.listarID(a);
        }

        public int Insertar(Detalle_pedido detalle_Pedido)
        {
            DAODetalle_pedido daDetalle_pedido = new DAODetalle_pedido();
            return daDetalle_pedido.Insertar(detalle_Pedido);
        }

        public int Actualizar(Detalle_pedido detalle_Pedido)
        {
            DAODetalle_pedido daDetalle_pedido = new DAODetalle_pedido();
            return daDetalle_pedido.Actualizar(detalle_Pedido);
        }

        public int Eliminar(Detalle_pedido detalle_Pedido)
        {
            DAODetalle_pedido daDetalle_pedido = new DAODetalle_pedido();
            return daDetalle_pedido.Eliminar(detalle_Pedido);
        }
    }
}
