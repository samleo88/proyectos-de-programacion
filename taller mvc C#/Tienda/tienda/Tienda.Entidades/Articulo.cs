using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tienda.Entidades
{
    public class Articulo
    {
        int _Idarticulo;
        string _Codigo;
        string _Nombre;
        string _Descripcion;
        Int64 _Idcategoria;
        Int64 _Precio_compra;
        Int64 _Precio_venta;
        Int64 _Stock_inicial;
        Int64 _Stock_actual;
        string _Fecha_produccion;
        string _Fecha_vencimiento;


        //Propiedades Métodos Set y Get

        public int Idarticulo
        {
            get { return _Idarticulo; }
            set { _Idarticulo = value; }
        }
        public string Codigo
        {
            get { return _Codigo; }
            set { _Codigo = value; }
        }
        public string Nombre
        {
            get { return _Nombre; }
            set { _Nombre = value; }
        }
        public string Descripcion
        {
            get { return _Descripcion; }
            set { _Descripcion = value; }
        }
        public Int64 Idcategoria
        {
            get { return _Idcategoria; }
            set { _Idcategoria = value; }
        }
        public Int64 Precio_venta
        {
            get { return _Precio_venta; }
            set { _Precio_venta = value; }
        }
        public Int64 Precio_compra
        {
            get { return _Precio_compra; }
            set { _Precio_compra = value; }
        }
        public Int64 Stock_inicial
        {
            get { return _Stock_inicial; }
            set { _Stock_inicial = value; }
        }
        public Int64 Stock_actual
        {
            get { return _Stock_actual; }
            set { _Stock_actual = value; }
        }
        public string Fecha_produccion
        {
            get { return _Fecha_produccion; }
            set { _Fecha_produccion = value; }
        }
        public string Fecha_vencimiento
        {
            get { return _Fecha_vencimiento; }
            set { _Fecha_vencimiento = value; }
        }

        //Constructores

        public Articulo(int idarticulo, string codigo, string nombre, string descripcion,
             int idcategoria, Int64 precio_compra, Int64 precio_venta, Int64 stock_inicial, Int64 stock_actual, 
            string fecha_produccion, string fecha_vencimiento)
        {
            this.Idarticulo = idarticulo;
            this.Codigo = codigo;
            this.Nombre = nombre;
            this.Descripcion = descripcion;
            this.Idcategoria = idcategoria;
            this.Precio_compra = precio_compra;
            this.Precio_venta = precio_venta;
            this.Stock_inicial = stock_inicial;
            this.Stock_actual = stock_actual;
            this.Fecha_produccion = fecha_produccion;
            this.Fecha_vencimiento = fecha_vencimiento;
         }
        public  Articulo(int idarticulo, string codigo, string nombre, string descripcion,
             int idcategoria, Int64 precio_compra, Int64 precio_venta, Int64 stock_inicial, Int64 stock_actual,
            string fecha_produccion, string fecha_vencimiento, string txtbuscar) :
            this(0, "", "", "", 0, 0, 0, 0, 0,"","" )
        {
        }
        public Articulo( int idarticulo, string codigo) : this(0, codigo, "", "", 0, 0, 0,0, 0,"","" )
        {
        }
        public Articulo(string codigo, string nombre) : this(0, "", nombre, "", 0, 0, 0, 0, 0, "", "")
        {
        }
        public Articulo(string nombre, int idcategoria) : this(0, "", "", "", idcategoria,0,0,0,0,"","","")
        {
        }
        public Articulo() : this(0, "", "", "", 0, 0, 0, 0, 0, "", "")
        {
        }
        
        
    }
}
