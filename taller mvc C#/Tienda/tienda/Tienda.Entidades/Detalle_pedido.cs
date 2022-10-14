using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tienda.Entidades
{
   public class Detalle_pedido
    {
        int _IdDetalle;
        int _IdPedido;
        int _IdArticulo;
        string _Nombre;
        decimal _Precio_unitario;
        decimal _Valor_total;
        int _Cantidad;
        //Propiedades Métodos Set y Get

        public int IdDetalle { get => _IdDetalle; set => _IdDetalle = value; }
        public int IdPedido { get => _IdPedido; set => _IdPedido = value; }
        public int IdArticulo { get => _IdArticulo; set => _IdArticulo = value; }
        public decimal Precio_unitario { get => _Precio_unitario; set => _Precio_unitario = value; }
        public decimal Valor_total { get => _Valor_total; set => _Valor_total = value; }
        public int Cantidad { get => _Cantidad; set => _Cantidad = value; }
        public string Nombre { get => _Nombre; set => _Nombre = value; }


        //Constructores

        public Detalle_pedido (int iddetalle, int idpedido,  int idarticulo, string nombre, decimal precio_unitario, decimal valor_total, int cantidad)
        {
            this.IdDetalle = iddetalle;
            this.IdPedido = idpedido;
            this.IdArticulo = idarticulo;
            this.Nombre = nombre;
            this.Precio_unitario = precio_unitario;
            this.Valor_total = valor_total;
            this.Cantidad = cantidad;                      
        }

        public Detalle_pedido(int iddetalle, int idpedido, int idarticulo,  string nombre, decimal precio_unitario, decimal valor_total, int cantidad, string textbuscar)
           : this(0,0,0,"",0,0,0)
        {            
        }
        public Detalle_pedido(int iddetalle,int idpedido, int idarticulo, decimal precio_unitario,  int cantidad, decimal valor_total)
           : this(0, 0, 0,"",0,  0, 0)
        {
        }

        public Detalle_pedido(int iddetalle)
          : this(0, 0, 0,"", 0, 0, 0)
        {
        }

        public Detalle_pedido(int iddetalle, int idpedido)
         : this(0, 0, 0, "", 0, 0, 0)
        {
        }

        public Detalle_pedido(int iddetalle, int idpedido, int idarticulo)
         : this(0, 0, 0, "", 0, 0, 0)
        {
        }

        public Detalle_pedido(int iddetalle, int idpedido, int idarticulo, int cantidad)
         : this(0, 0, 0,"",  0, 0, 0)
        {
        }
        public Detalle_pedido()
         : this(0, 0, 0, "", 0, 0, 0)
        {
        }
    }
}
