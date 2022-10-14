using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using System.Data.SqlClient;
using Tienda.Entidades;
using Tienda.Negocio;

namespace TiendaWindows
{
    public partial class FormLogin : Form
    {
        public FormLogin()
        {
            InitializeComponent();
            
        }

        EntidadLogin objEntidad = new EntidadLogin();
        NegocioLogin objNegocio = new NegocioLogin();

        private void txtSalir_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void txtIngresar_Click(object sender, EventArgs e)
        {
            objEntidad.Usuario = txtUsuario.Text;
            objEntidad.Password = txtPassword.Text;

            DataTable tbl = objNegocio.LogonN(objEntidad);
            if (tbl.Rows.Count == 0)
            {
                MessageBox.Show("No cohensiden Usuario y Contraseña \n Intentelo nuevamente",
                    "Acceso al Sistema", MessageBoxButtons.OK, MessageBoxIcon.Error);
                txtUsuario.Text = "";
                txtPassword.Text = "";
                txtUsuario.Focus();
            }
            else
            {
                MessageBox.Show("Bienvenido al Sistema", "Acceso al Sistema", MessageBoxButtons.OK);

                if (tbl.Rows[0][3].ToString()=="administrador")
                {
                    program.vacceso = "1";
                    
                    FormPrincipal Frm = new FormPrincipal();
                    Frm.Show();
                }
                else
                {
                    program.vacceso = "0";
                    FormPrincipal Frm1 = new FormPrincipal();
                    Frm1.Show();
                }
            }



            /*DataTable Datos = Tienda.Negocio(this.txtUsuario.Text,this.txtPassword.Text);
            //Evaluar si existe el Usuario
            if (Datos.Rows.Count==0)
            {
                MessageBox.Show("NO Tiene Acceso al Sistema","Sistema de Ventas",MessageBoxButtons.OK,MessageBoxIcon.Error);
            }
            else
            {
                FormVendedor frm = new ();
                frm.Id = Datos.Rows[0][0].ToString();
                frm.Apellidos = Datos.Rows[0][1].ToString();
                frm.Nombre = Datos.Rows[0][2].ToString();
                frm.Acceso = Datos.Rows[0][3].ToString();

                frm.Show();
                this.Hide();

            }*/
        }
    }
}
