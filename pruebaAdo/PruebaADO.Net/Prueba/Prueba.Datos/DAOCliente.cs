using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Configuration;
using System.Data.SqlClient;
using System.Data;

using Prueba.Entidades;

namespace Prueba.Datos
{
  public  class DAOCliente
    {

        

        public List<Cliente> Listar()
        {
            List<Cliente> lista = new List<Cliente>();


            using (IDbConnection con = DBcommon.Conexion())
               // using(SqlConnection con = new SqlConnection())

            {
                con.Open();
                SqlCommand cmd = new SqlCommand("ListarClientes", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr != null && dr.HasRows)
                {
                    while (dr.Read())
                    {
                        Cliente c = new Cliente(
                            (int)dr["ID"],
                            (string)dr["Nombre"],
                            (string)dr["Apellido"],                           
                            (string)dr["Direccion"]
                            );
                        lista.Add(c);
                    }
                }
            }
            return lista;
        }

        public Cliente TraerPorId(int Id)
        {
            Cliente cliente = new Cliente();
            //using (SqlConnection con = new SqlConnection())
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("TraerClientePorId", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@ID", Id);
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr != null && dr.HasRows)
                {
                    dr.Read();
                    cliente = new Cliente(
                        (int)dr["ID"],
                        (string)dr["Nombre"],
                        (string)dr["Apellido"],
                        (string)dr["Direccion"]
                        );
                }
            }
            return cliente;
        }

        public int Insertar(Cliente cliente)
        {
            int n = -1;
            //using (SqlConnection con = new SqlConnection(CadenaConexion))
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("InsertarCliente", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;

                cmd.Parameters.AddWithValue("@Nombre", cliente.Nombre);
                cmd.Parameters.AddWithValue("@Apellido", cliente.Apellidos);
                cmd.Parameters.AddWithValue("@Direccion", cliente.Direccion);

                n = cmd.ExecuteNonQuery();
            }
            return n;
        }

        public int Actualizar(Cliente cliente)
        {
            int n = -1;
            //using (SqlConnection con = new SqlConnection(CadenaConexion))
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("ActualizarCliente", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@Idcliente", cliente.Idcliente);
                cmd.Parameters.AddWithValue("@Nombre", cliente.Nombre);
                cmd.Parameters.AddWithValue("@Apellido", cliente.Apellidos);
                cmd.Parameters.AddWithValue("@Direccion", cliente.Direccion);
                n = cmd.ExecuteNonQuery();
            }
            return n;
        }

        public int Eliminar(int Id)
        {
            int n = -1;
            //using (SqlConnection con = new SqlConnection(CadenaConexion))
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("EliminarCliente", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@ID", Id);
                n = cmd.ExecuteNonQuery();
            }
            return n;
        }

    }
}
