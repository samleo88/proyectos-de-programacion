using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tienda.Entidades
{
    public class Pedido
    {
        int _Idpedido;
        int _Idcliente;
        int _Idvendedor;
        decimal _Total_pedido;
        string _Fecha_pedido;
        string _Aceptacion_pedido;
        //Propiedades Métodos Set y Get
        public int Idpedido
        {
            get { return _Idpedido; }
            set { _Idpedido = value; }
        }
        public int Idcliente
        {
            get { return _Idcliente; }
            set { _Idcliente = value; }
        }
        public int Idvendedor
        {
            get { return _Idvendedor; }
            set { _Idvendedor = value; }
        }
        public decimal Total_pedido
        {
            get { return _Total_pedido; }
            set { _Total_pedido = value; }
        }
        public string Fecha_pedido
        {
            get { return _Fecha_pedido; }
            set { _Fecha_pedido = value; }
        }
        public string Aceptacion_pedido
        {
            get { return _Aceptacion_pedido; }
            set { _Aceptacion_pedido = value; }
        }


        //Constructores

        public Pedido(int idpedido,int idcliente, int idvendedor, decimal total_pedido,
            string fecha_pedido, string aceptacion_pedido)
        {
            this.Idpedido = idpedido;
            this.Idcliente = idcliente;
            this.Idvendedor = idvendedor;
            this.Total_pedido = total_pedido;
            this.Fecha_pedido = fecha_pedido;
            this.Aceptacion_pedido = aceptacion_pedido;
           
        }

        public Pedido(int idpedido, int idcliente, int idvendedor,  decimal total_pedido, string fecha_pedido, string aceptacion_pedido, string bucartxt) :
            this( 0, 0, 0, 0, "", "")
        {
        }

        public Pedido(int idpedido) : this(0, 0, 0, 0, "", "")
        {
        }
        public Pedido(int idpedido, int idvendedor) : this(0, 0, 0, 0, "", "")
        {
        }

        public Pedido(int idpedido, int idcliente, int idvendedor) : this(0,0, 0, 0, "", "")
        {
        }

        public Pedido(int idpedido, int idcliente, int idvendedor, decimal total_pedido) : this(0, 0, 0, 0, "", "")
        {
        }

        public Pedido() : this(0, 0, 0, 0, "", "")
        {
        }
    }
}
