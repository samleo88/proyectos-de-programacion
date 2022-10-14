using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Configuration;
using System.Data.SqlClient;
using System.Data;
using Tienda.Entidades;

namespace Tienda.Datos
{
    public class DAOVendedor
    {

        public List<Vendedor> Listar()
        {
            List<Vendedor> lista = new List<Vendedor>();


            using (IDbConnection con = DBcommon.Conexion())
            //    using(SqlConnection con = new SqlConnection())

            {
                con.Open();
                SqlCommand cmd = new SqlCommand("Listarvendedor", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr != null && dr.HasRows)
                {
                    while (dr.Read())
                    {
                        Vendedor c = new Vendedor(
                            (int)dr["ID"],
                            (string)dr["Nombre"],
                            (string)dr["Apellido"],
                            (string)dr["Sexo"],
                            (string)dr["Tipo_documento"],
                            (string)dr["Num_documento"],
                            (string)dr["Direccion"],
                            (string)dr["Telefono"],
                            (string)dr["Email"],
                            (string)dr["Acceso"],
                            (string)dr["Usuario"],
                            (string)dr["Password"]
                            );
                        lista.Add(c);
                    }
                }
            }
            return lista;
        }

        public Vendedor TraerPorId(int Id)
        {
            Vendedor vendedor = new Vendedor();
            //using (SqlConnection con = new SqlConnection())
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("TraerVendedorPorId", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@ID", Id);
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr != null && dr.HasRows)
                {
                    dr.Read();
                    vendedor = new Vendedor(
                        (int)dr["ID"],
                            (string)dr["Nombre"],
                            (string)dr["Apellido"],
                            (string)dr["Sexo"],
                            (string)dr["Tipo_documento"],
                            (string)dr["Num_documento"],
                            (string)dr["Direccion"],
                            (string)dr["Telefono"],
                            (string)dr["Email"],
                            (string)dr["Acceso"],
                            (string)dr["Usuario"],
                            (string)dr["Password"]
                        );
                }
            }
            return vendedor;
        }

        public int Insertar(Vendedor vendedor)
        {
            int n = -1;

            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("InsertarVendedor", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;

                cmd.Parameters.AddWithValue("@Nombre", vendedor.Nombre);
                cmd.Parameters.AddWithValue("@Apellido", vendedor.Apellidos);
                cmd.Parameters.AddWithValue("@Sexo", vendedor.Sexo);
                cmd.Parameters.AddWithValue("@Tipo_documento", vendedor.Tipo_Documento);
                cmd.Parameters.AddWithValue("@Num_documento", vendedor.Num_Documento);
                cmd.Parameters.AddWithValue("@Direccion", vendedor.Direccion);
                cmd.Parameters.AddWithValue("@Telefono", vendedor.Telefono);
                cmd.Parameters.AddWithValue("@Email", vendedor.Email);
                cmd.Parameters.AddWithValue("@Acceso", vendedor.Acceso);
                cmd.Parameters.AddWithValue("@Usuario", vendedor.Usuario);
                cmd.Parameters.AddWithValue("@Password", vendedor.Password);
                n = cmd.ExecuteNonQuery();
            }
            return n;
        }

        public int Actualizar(Vendedor vendedor)
        {
            int n = -1;
            //using (SqlConnection con = new SqlConnection(CadenaConexion))
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("ActualizarVendedor", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@Idvendedor", vendedor.Idvendedor);
                cmd.Parameters.AddWithValue("@Nombre", vendedor.Nombre);
                cmd.Parameters.AddWithValue("@Apellido", vendedor.Apellidos);
                cmd.Parameters.AddWithValue("@Sexo", vendedor.Sexo);
                cmd.Parameters.AddWithValue("@Tipo_documento", vendedor.Tipo_Documento);
                cmd.Parameters.AddWithValue("@Num_documento", vendedor.Num_Documento);
                cmd.Parameters.AddWithValue("@Direccion", vendedor.Direccion);
                cmd.Parameters.AddWithValue("@Telefono", vendedor.Telefono);
                cmd.Parameters.AddWithValue("@Email", vendedor.Email);
                cmd.Parameters.AddWithValue("@Acceso", vendedor.Acceso);
                cmd.Parameters.AddWithValue("@Usuario", vendedor.Usuario);
                cmd.Parameters.AddWithValue("@Password", vendedor.Password);
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
                SqlCommand cmd = new SqlCommand("EliminarVendedor", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@ID", Id);
                n = cmd.ExecuteNonQuery();
            }
            return n;
        }

        

    }
}