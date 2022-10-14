using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Tienda.Entidades;
using Tienda.Negocio;

namespace TiendaWindows
{
    public partial class FormCliente : Form
    {
       List <Cliente> lista = null;
        BLCliente blCliente = new BLCliente();
        Cliente c;
        bool _nuevo = false;
        public FormCliente()
        {
            InitializeComponent();
            ActivarControlDatos(gbDatos, false);
            CargarDatos();
        }

        private void ActivarControlDatos(Control Contenedor, bool Estado)
        {
            try
            {
                foreach (var item in Contenedor.Controls)
                {
                    if (item.GetType() == typeof(TextBox))
                    {
                        ((TextBox)item).Enabled = Estado;
                    }
                }
            }
            catch (Exception)
            {

            }
        }

        private void LimpiarControl(Control Contenedor)
        {
            foreach (var item in Contenedor.Controls)
            {
                if (item.GetType() == typeof(TextBox))
                {
                    ((TextBox)item).Clear();
                }
            }
        }

        private void ActivarButton(bool Estado)
        {
            btnNuevo.Enabled = Estado;
            btnGrabar.Enabled = !Estado;
            btnEliminar.Enabled = Estado;
            btnSalir.Enabled = Estado;
        }

        private void CargarDatos()
        {
            if (lista == null)
            {
                lista = blCliente.Listar();
            }
            if (lista.Count > 0)
            {
                dgvDatos.Rows.Clear();
                for (int i = 0; i < lista.Count; i++)
                {
                   dgvDatos.Rows.Add(lista[i].Idcliente, lista[i].Nombre, lista[i].Apellidos, lista[i].Sexo,
                       lista[i].Tipo_Documento, lista[i].Num_Documento, lista[i].Direccion, lista[i].Telefono, lista[i].Email);
                }
            }
        }

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            _nuevo = true;
            ActivarControlDatos(gbDatos, true);
            btnEditar.Text = "Cancelar";
            ActivarButton(false);
            LimpiarControl(gbDatos);
            txtNombre.Focus();
        }

        private void btnGrabar_Click(object sender, EventArgs e)
        {
            int n = -1;
            if (_nuevo)
            {
                c = new Cliente(0,
                    txtNombre.Text,
                    txtApellido.Text,
                    txtSexo.Text,
                    txtTipo_documento.Text,
                    txtNum_documento.Text,
                    txtDirreccion.Text,
                    txtTelefono.Text,
                    txtEmail.Text);
                n = blCliente.Insertar(c);
            }
            else
            {
                
                c.Nombre = txtNombre.Text;
                c.Apellidos = txtApellido.Text;
                c.Sexo = txtSexo.Text;
                c.Tipo_Documento = txtTipo_documento.Text;
                c.Num_Documento = txtNum_documento.Text;
                c.Direccion = txtDirreccion.Text;
                c.Telefono = txtTelefono.Text;
                c.Email = txtEmail.Text;
                n = blCliente.Actualizar(c);
            }
            if (n > 0)
            {
                MessageBox.Show("Datos grabados correctamente", "Aviso",
                    MessageBoxButtons.OK, MessageBoxIcon.Information);
                ActivarControlDatos(gbDatos, false);
                ActivarButton(true);
                dgvDatos.Enabled = true;
                LimpiarControl(gbDatos);
                btnEditar.Text = "Editar";
                lista = blCliente.Listar();
                CargarDatos();
            }
            else
            {
                MessageBox.Show("Error al grabar", "Aviso",
                    MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btnEditar_Click(object sender, EventArgs e)
        {
            _nuevo = false;
            if (btnEditar.Text == "Cancelar")
            {
                LimpiarControl(gbDatos);
                ActivarControlDatos(gbDatos, false);
                ActivarButton(true);
                dgvDatos.Enabled = true;
                btnEditar.Text = "Editar";
            }
            else
            {
                if (dgvDatos.RowCount > 0)
                {
                    c = blCliente.TraerPorId((int)dgvDatos[0, dgvDatos.
                        CurrentRow.Index].Value);
                    txtNombre.Text = c.Nombre;
                    txtApellido.Text = c.Apellidos;
                    txtSexo.Text = c.Sexo;
                    txtTipo_documento.Text = c.Tipo_Documento;
                    txtNum_documento.Text = c.Num_Documento;
                    txtDirreccion.Text = c.Direccion;
                    txtTelefono.Text = c.Telefono;
                    txtEmail.Text = c.Email;
                    ActivarControlDatos(gbDatos, true);
                    ActivarButton(false);
                    dgvDatos.Enabled = false;
                    btnEditar.Text = "Cancelar";
                }
            }
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            if (dgvDatos.RowCount > 0)
            {
                c = blCliente.TraerPorId((int)dgvDatos[0, dgvDatos.
                    CurrentRow.Index].Value);
                DialogResult rpta =
                    MessageBox.Show("Desea eliminar el registro", "Eliminar",
                    MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                if (rpta == System.Windows.Forms.DialogResult.Yes)
                {
                    int n = blCliente.Eliminar(c.Idcliente);
                    if (n > 0)
                    {
                        MessageBox.Show("Registro eliminado", "Aviso",
                            MessageBoxButtons.OK, MessageBoxIcon.Information);
                        lista = blCliente.Listar();
                        CargarDatos();
                    }
                    else
                    {
                        MessageBox.Show("Error al eliminar", "Aviso",
                            MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }

            }
        }

        private void btnSalir_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
