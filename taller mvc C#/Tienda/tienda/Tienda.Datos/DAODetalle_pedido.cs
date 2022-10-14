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
    public class DAODetalle_pedido
    {
        public List<Detalle_pedido> Listar()
        {
            List<Detalle_pedido> lista = new List<Detalle_pedido>();


            using (IDbConnection con = DBcommon.Conexion())
            //    using(SqlConnection con = new SqlConnection())

            {
                con.Open();
                SqlCommand cmd = new SqlCommand("ListarDetalle_pedido", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr != null && dr.HasRows)
                {
                    while (dr.Read())
                    {
                        Detalle_pedido c = new Detalle_pedido(
                             (int)dr["ID"],
                             (int)dr["IdPedido"],
                             (int)dr["IdArticulo"],
                             (string)dr["Nombre"],
                             (decimal)dr["Precio_unitario"],
                             (decimal)dr["Valor_total"],
                             (int)dr["Cantidad"]

                             );
                        lista.Add(c);
                    }
                }
            }
            return lista;
        }

        public List<Detalle_pedido> listarID(int a){
            List<Detalle_pedido> listar = new List<Detalle_pedido>();


            using (IDbConnection con = DBcommon.Conexion())
            //    using(SqlConnection con = new SqlConnection())

            {
                con.Open();
                SqlCommand cmd = new SqlCommand("TraerDetalle_pedidoPorId", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@ID", a);
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr != null && dr.HasRows)
                {
                    while (dr.Read())
                    {
                        Detalle_pedido c = new Detalle_pedido(
                             (int)dr["ID"],
                             (int)dr["IdPedido"],
                             (int)dr["IdArticulo"],
                             (string)dr["Nombre"],
                             (decimal)dr["Precio_unitario"],
                             (decimal)dr["Valor_total"],
                             (int)dr["Cantidad"]

                             );
                listar.Add(c);
                    }
                }
            }
            return listar;


            }

        public Detalle_pedido TraerPorId(int Id)
        {
            Detalle_pedido detalle_pedido = new Detalle_pedido();
            //using (SqlConnection con = new SqlConnection())
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("TraerDetall_pedidoPorId", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@ID", Id);
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr != null && dr.HasRows)
                {
                    dr.Read();
                    detalle_pedido = new Detalle_pedido(
                       (int)dr["ID"],
                            (int)dr["IdPedido"],
                            (int)dr["IdArticulo"],
                            (string)dr["Nombre"],
                            (decimal)dr["Precio_unitario"],
                            (decimal)dr["Valor_total"],
                            (int)dr["Cantidad"]
                        );
                }
            }
            return detalle_pedido;
        }

        public int Insertar(Detalle_pedido detalle_Pedido)
        {
            int n = -1;

            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("InsertarDetalle_pedido", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;

               
                cmd.Parameters.AddWithValue("@IdPedido", detalle_Pedido.IdPedido);
                cmd.Parameters.AddWithValue("@IdArticulo", detalle_Pedido.IdArticulo);
                cmd.Parameters.AddWithValue("@Precio_unitario", detalle_Pedido.Precio_unitario);
                cmd.Parameters.AddWithValue("@Valor_total", detalle_Pedido.Valor_total);
                cmd.Parameters.AddWithValue("@Cantidad", detalle_Pedido.Cantidad);
                
                n = cmd.ExecuteNonQuery();
            }
            return n;
        }

        public int Actualizar(Detalle_pedido detalle_Pedido)
        {
            int n = -1;
            //using (SqlConnection con = new SqlConnection(CadenaConexion))
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("ActualizarDetalle_pedido", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@IdDetalle", detalle_Pedido.IdDetalle);
                cmd.Parameters.AddWithValue("@IdPedido", detalle_Pedido.IdPedido);
                cmd.Parameters.AddWithValue("@IdArticulo", detalle_Pedido.IdArticulo);
                cmd.Parameters.AddWithValue("@Nombre", detalle_Pedido.IdArticulo);
                cmd.Parameters.AddWithValue("@Precio_unitario", detalle_Pedido.Precio_unitario);
                cmd.Parameters.AddWithValue("@Valor_total", detalle_Pedido.Valor_total);
                cmd.Parameters.AddWithValue("@Cantidad", detalle_Pedido.Cantidad);
               

                n = cmd.ExecuteNonQuery();
            }
            return n;
        }

        public int Eliminar(Detalle_pedido detalle_Pedido)
        {
            int n = -1;
            // using (SqlConnection con = new SqlConnection(CadenaConexion))
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("EliminarDetalle_pedido", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@ID", detalle_Pedido.IdDetalle);
                cmd.Parameters.AddWithValue("@IdPedido", detalle_Pedido.IdPedido);
                n = cmd.ExecuteNonQuery();
            }
            return n;
        }

    }
}
