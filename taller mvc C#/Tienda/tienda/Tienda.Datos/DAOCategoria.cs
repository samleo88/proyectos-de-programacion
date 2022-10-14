using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.OleDb;
using Tienda.Entidades;
using System.Configuration;
using System.Data.SqlClient;
using System.Data;




namespace Tienda.Datos
{
   public  class DAOCategoria
    {

        /*string _cadenaConexion  ;

        public string CadenaConexion
        {
            get
            {
                if (_cadenaConexion == null)
                {
                    _cadenaConexion = ConfigurationManager.ConnectionStrings["Conex"].ConnectionString;
                }
                return _cadenaConexion;
            }
            set { _cadenaConexion = value; }
        }*/



        public List<Categoria> Listar()
        {
            List<Categoria> lista = new List<Categoria>();
          

           using (IDbConnection con = DBcommon.Conexion())
            //    using(SqlConnection con = new SqlConnection())

            {
                con.Open();
                SqlCommand cmd = new SqlCommand("ListarCategorias", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr != null && dr.HasRows)
                {
                    while (dr.Read())
                    {
                        Categoria c = new Categoria((int)dr["ID"],
                            (string)dr["Codigo"], (string)dr["Nombre"],
                            (string)dr["Observacion"]);
                        lista.Add(c);
                    }
                }
            }
            return  lista;
        }

        public Categoria TraerPorId(int Id)
        {
            Categoria Categoria = new Categoria();
            //using (SqlConnection con = new SqlConnection())
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("TraerCategoriaPorId", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@ID", Id);
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr != null && dr.HasRows)
                {
                    dr.Read();
                    Categoria = new Categoria((int)dr["ID"],
                        (string)dr["Codigo"], (string)dr["Nombre"],
                        (string)dr["Observacion"]);
                }
            }
            return Categoria;
        }

        public int Insertar(Categoria Categoria)
        {
            int n = -1;
            
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("InsertarCategoria",con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@Codigo", Categoria.Codigo);
                cmd.Parameters.AddWithValue("@Nombre", Categoria.Nombre);
                cmd.Parameters.AddWithValue("@Observacion", Categoria.Descripcion);
                n = cmd.ExecuteNonQuery();
            }
            return n;
        }

        public int Actualizar(Categoria Categoria)
        {
            int n = -1;
            //using (SqlConnection con = new SqlConnection(CadenaConexion))
            using (IDbConnection con = DBcommon.Conexion())
            {
                con.Open();
                SqlCommand cmd = new SqlCommand("ActualizarCategoria", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@Id", Categoria.Id);
                cmd.Parameters.AddWithValue("@Codigo", Categoria.Codigo);
                cmd.Parameters.AddWithValue("@Nombre", Categoria.Nombre);
                cmd.Parameters.AddWithValue("@Observacion", Categoria.Descripcion);
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
                SqlCommand cmd = new SqlCommand("EliminarCategoria", con as SqlConnection);
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@Id", Id);
                n = cmd.ExecuteNonQuery();
            }
            return n;
        }


    }
}
