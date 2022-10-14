using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Data;
using Tienda.Entidades;

namespace Tienda.Datos
{
    public class DAOArticulo
    {
        public List<Articulo> Listar()
        {
            List<Articulo> lista = new List<Articulo>();


            using (IDbConnection con = DBcommon.Conexion())
            //    using(SqlConnection con = new SqlConnection())

            {
                con.Open();
                SqlCommand cmd = new SqlCommand("ListarArticulo", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr != null && dr.HasRows)
                {
                    while (dr.Read())
                    {
                        Articulo c = new Articulo(
                            (int)dr["ID"],
                            (string)dr["Codigo"],
                            (string)dr["Nombre"],
                            (string)dr["Descripcion"],
                            (int)dr["IdCategoria"],
                            (Int64)dr["Precio_compra"],
                            (Int64)dr["Precio_venta"],
                            (Int64)dr["Stock_inicial"],
                            (Int64)dr["Stock_actual"],
                            (string)dr["Fecha_produccion"],
                            (string)dr["Fecha_vencimiento"]
                            
                            );
                        lista.Add(c);
                    }
                }
            }
            return lista;
        }

        public Articulo TraerPorId(int Id)
        {
            Articulo articulo = new Articulo();
            //using (SqlConnection con = new SqlConnection())
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("TraerArticuloPorId", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@ID", Id);
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr != null && dr.HasRows)
                {
                    dr.Read();
                    articulo = new Articulo(
                        (int)dr["ID"],
                        (string)dr["Codigo"],
                        (string)dr["Nombre"],
                        (string)dr["Descripcion"],
                        (int)dr["IdCategoria"],
                        (Int64)dr["Precio_compra"],
                        (Int64)dr["Precio_venta"],
                        (Int64)dr["Stock_inicial"],
                        (Int64)dr["Stock_actual"],
                        (string)dr["Fecha_produccion"],
                        (string)dr["Fecha_vencimiento"]                         
                        );
                }
            }
            return articulo;
        }

        public int Insertar(Articulo articulo)
        {
            int n = -1;

            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("InsertarArticulo", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;

                cmd.Parameters.AddWithValue("@Codigo", articulo.Codigo);
                cmd.Parameters.AddWithValue("@Nombre", articulo.Nombre);
                cmd.Parameters.AddWithValue("@Descripcion", articulo.Descripcion);
                cmd.Parameters.AddWithValue("@IdCategoria", articulo.Idcategoria);
                cmd.Parameters.AddWithValue("@Precio_compra", articulo.Precio_compra);
                cmd.Parameters.AddWithValue("@Precio_venta", articulo.Precio_venta);
                cmd.Parameters.AddWithValue("@Stock_inicial", articulo.Stock_inicial);
                cmd.Parameters.AddWithValue("@Stock_actual", articulo.Stock_actual);
                cmd.Parameters.AddWithValue("@Fecha_produccion", articulo.Fecha_produccion);
                cmd.Parameters.AddWithValue("@Fecha_vencimiento", articulo.Fecha_vencimiento);
                
                n = cmd.ExecuteNonQuery();
            }
            return n;
        }

        public int Actualizar(Articulo articulo)
        {
            int n = -1;
            //using (SqlConnection con = new SqlConnection(CadenaConexion))
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("ActualizarArticulo", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@IdArticulo", articulo.Idarticulo);
                cmd.Parameters.AddWithValue("@Codigo", articulo.Codigo);
                cmd.Parameters.AddWithValue("@Nombre", articulo.Nombre);
                cmd.Parameters.AddWithValue("@Descripcion", articulo.Descripcion);
                cmd.Parameters.AddWithValue("@IdCategoria", articulo.Idcategoria);
                cmd.Parameters.AddWithValue("@Precio_compra", articulo.Precio_compra);
                cmd.Parameters.AddWithValue("@Precio_venta", articulo.Precio_venta);
                cmd.Parameters.AddWithValue("@Stock_inicial", articulo.Stock_inicial);
                cmd.Parameters.AddWithValue("@Stock_actual", articulo.Stock_actual);
                cmd.Parameters.AddWithValue("@Fecha_produccion", articulo.Fecha_produccion);
                cmd.Parameters.AddWithValue("@Fecha_vencimiento", articulo.Fecha_vencimiento);


                n = cmd.ExecuteNonQuery();
            }
            return n;
        }

        public int Eliminar(int Id)
        {
            int n = -1;
            // using (SqlConnection con = new SqlConnection(CadenaConexion))
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("EliminarArticulo", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@ID", Id);
                n = cmd.ExecuteNonQuery();
            }
            return n;
        }

    }
}
