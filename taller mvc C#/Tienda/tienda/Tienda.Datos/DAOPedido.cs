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
    public class DAOPedido
    {
        public List<Pedido> Listar()
        {
            List<Pedido> lista = new List<Pedido>();


            using (IDbConnection con = DBcommon.Conexion())
            //    using(SqlConnection con = new SqlConnection())

            {
                con.Open();
                SqlCommand cmd = new SqlCommand("ListarPedido", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr != null && dr.HasRows)
                {
                    while (dr.Read())
                    {
                        Pedido c = new Pedido(
                            (int)dr["ID"],
                            (int)dr["IdCliente"],
                            (int)dr["IdVendedor"],
                            (decimal)dr["Total_pedido"],
                            (string)dr["Fecha_pedido"],
                            (string)dr["Aceptacion_pedido"]

                            );
                        lista.Add(c);
                    }
                }
            }
            return lista;
        }

        public Pedido TraerPorId(int Id)
        {
            Pedido pedido = new Pedido();
            //using (SqlConnection con = new SqlConnection())
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("TraerPedidoPorId", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@ID", Id);
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr != null && dr.HasRows)
                {
                    dr.Read();
                    pedido  = new Pedido(
                        (int)dr["ID"],
                            (int)dr["IdCliente"],
                            (int)dr["IdVendedor"],
                            (decimal)dr["Total_pedido"],
                            (string)dr["Fecha_pedido"],
                            (string)dr["Aceptacion_pedido"]

                        );
                }
            }
            return pedido;
        }

        public int Insertar(Pedido pedido)
        {
            int n = -1;

            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("InsertarPedido", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;        
               // cmd.Parameters.AddWithValue("@IdPedido", pedido.Idpedido);
                cmd.Parameters.AddWithValue("@IdCliente", pedido.Idcliente);
                cmd.Parameters.AddWithValue("@IdVendedor", pedido.Idvendedor);
                cmd.Parameters.AddWithValue("@Total_pedido", pedido.Total_pedido);
                cmd.Parameters.AddWithValue("@Fecha_pedido", pedido.Fecha_pedido);
                cmd.Parameters.AddWithValue("@Aceptacion_pedido", pedido.Aceptacion_pedido);
                n = cmd.ExecuteNonQuery();
            }
            return n;
        }

        public int Actualizar(Pedido pedido)
        {
            int n = -1;
            //using (SqlConnection con = new SqlConnection(CadenaConexion))
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("ActualizarPedido", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@IdPedido", pedido.Idpedido);
                cmd.Parameters.AddWithValue("@IdCliente", pedido.Idcliente);
                cmd.Parameters.AddWithValue("@IdVendedor", pedido.Idvendedor);
                cmd.Parameters.AddWithValue("@Total_pedido", pedido.Total_pedido);
                cmd.Parameters.AddWithValue("@Fecha_pedido", pedido.Fecha_pedido);
                cmd.Parameters.AddWithValue("@Aceptacion_pedido", pedido.Aceptacion_pedido);

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
                SqlCommand cmd = new SqlCommand("EliminarPedido", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@ID", Id);
                n = cmd.ExecuteNonQuery();
            }
            return n;
        }
    }
}
