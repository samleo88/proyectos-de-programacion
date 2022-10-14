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
    public partial class FormArticulo : Form
    {
        List<Articulo> lista = null;
        BLArticulo bLArticulo = new BLArticulo();
        Articulo c;
        bool _nuevo = false;
        public FormArticulo()
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
                lista = bLArticulo.Listar();
            }
            if (lista.Count > 0)
            {
                dgvDatos.Rows.Clear();
                for (int i = 0; i < lista.Count; i++)
                {
                    dgvDatos.Rows.Add(lista[i].Idarticulo, lista[i].Codigo, lista[i].Nombre, lista[i].Descripcion,
                        lista[i].Idcategoria, lista[i].Precio_compra, lista[i].Precio_venta, lista[i].Stock_inicial, lista[i].Stock_actual,
                        lista[i].Fecha_produccion, lista[i].Fecha_vencimiento);
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
                c = new Articulo(0,
                    txtCodigo.Text,
                    txtNombre.Text,
                    txtDescripcion.Text,
                    Convert.ToInt16(txtIdCategoria.Text), 
                    Convert.ToInt64(txtPrecio_compra.Text),
                   Convert.ToInt64(txtPrecio_venta.Text),
                   Convert.ToInt64(txtStock_inicial.Text),
                    Convert.ToInt64(txtStock_actual.Text),
                    txtFechadeProduccion.Text,
                    txtFechadeVencimiento.Text);
                n = bLArticulo.Insertar(c);
            }
            else
            {

                
                c.Codigo = txtCodigo.Text;
                c.Nombre = txtNombre.Text;
                c.Descripcion = txtDescripcion.Text;
                c.Idcategoria = Convert.ToInt16(txtIdCategoria.Text);
                c.Precio_compra = Convert.ToInt64(txtPrecio_compra.Text);
                c.Precio_venta = Convert.ToInt64 (txtPrecio_venta.Text);
                c.Stock_inicial = Convert.ToInt64(txtStock_inicial.Text);
                c.Stock_actual = Convert.ToInt64(txtStock_actual.Text);
                c.Fecha_produccion = txtFechadeProduccion.Text;
                c.Fecha_vencimiento= txtFechadeVencimiento.Text;

                n = bLArticulo.Actualizar(c);
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
                lista = bLArticulo.Listar();
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
                    c = bLArticulo.TraerPorId((int)dgvDatos[0, dgvDatos.
                        CurrentRow.Index].Value);
                    txtCodigo.Text = c.Codigo;
                    txtNombre.Text = c.Nombre;
                    txtDescripcion.Text = c.Descripcion;
                    txtIdCategoria.Text = Convert.ToString(c.Idcategoria); 
                    txtPrecio_compra.Text = Convert.ToString(c.Precio_compra);
                    txtPrecio_venta.Text = Convert.ToString(c.Precio_venta);
                    txtStock_inicial.Text = Convert.ToString(c.Stock_inicial);
                    txtStock_actual.Text = Convert.ToString(c.Stock_actual);
                    txtFechadeProduccion.Text = c.Fecha_produccion;
                    txtFechadeVencimiento.Text = c.Fecha_vencimiento;
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

                c = bLArticulo.TraerPorId((int)dgvDatos[0, dgvDatos.
                    CurrentRow.Index].Value);
                DialogResult rpta =
                    MessageBox.Show("Desea eliminar el registro", "Eliminar",
                    MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                if (rpta == System.Windows.Forms.DialogResult.Yes)
                {
                    int n = bLArticulo.Eliminar(c.Idarticulo);
                    if (n > 0)
                    {
                        MessageBox.Show("Registro eliminado", "Aviso",
                            MessageBoxButtons.OK, MessageBoxIcon.Information);
                        lista = bLArticulo.Listar();
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
