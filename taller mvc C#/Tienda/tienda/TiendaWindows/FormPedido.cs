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
    public partial class FormPedido : Form
    {
        List<Pedido> lista = null;
        BLDetalle_pedido bLDetalle_Pedido = new BLDetalle_pedido();
        BLPedido bLPedido = new BLPedido();
        Pedido c;
        Detalle_pedido b;
        bool _nuevo = false;
        public FormPedido()
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
                lista = bLPedido.Listar();
            }
            if (lista.Count > 0)
            {
                dgvDatos.Rows.Clear();
                for (int i = 0; i < lista.Count; i++)
                {
                    //program.operacion = lista[i].Idpedido;
                    dgvDatos.Rows.Add(lista[i].Idpedido, lista[i].Idcliente, lista[i].Idvendedor, lista[i].Total_pedido,
                        lista[i].Fecha_pedido, lista[i].Aceptacion_pedido);
                }
            }
        }

        /*private void CargarDatos()
        {
            if (lista == null)
            {
                lista = bLDetalle_Pedido.Listar();
            }
            if (lista.Count > 0)
            {
                dgvDatos.Rows.Clear();
                for (int i = 0; i < lista.Count; i++)
                {
                    dgvDatos.Rows.Add(lista[i].IdDetalle, lista[i].IdPedido, lista[i].IdArticulo, lista[i].Nombre,
                        lista[i].Precio_unitario, lista[i].Cantidad, lista[i].Valor_total);
                }
            }
        }*/
        private void btnNuevo_Click(object sender, EventArgs e)
        {
            _nuevo = true;
            ActivarControlDatos(gbDatos, true);
            btnEditar.Text = "Cancelar";
            ActivarButton(false);
            LimpiarControl(gbDatos);
            txtValor_pedido.Focus();
        }

        private void btnGrabar_Click(object sender, EventArgs e)
        {
            int n = -1;
            if (_nuevo)
            {
                c = new Pedido(0,
                    
                    int.Parse(txtIdcliente.Text),
                    int.Parse(txtIdvendedor.Text),
                   decimal.Parse(txtValor_pedido.Text),                  
                    txtFecha_pedido.Text,
                    txtAceptacion_pedido.Text);
                n = bLPedido.Insertar(c);
            }
            else
            {


                
                c.Idcliente = int.Parse(txtIdcliente.Text);
                c.Idvendedor = int.Parse(txtIdvendedor.Text);

                // Consulta 
                c.Total_pedido = decimal.Parse(txtValor_pedido.Text);                
                c.Fecha_pedido= txtFecha_pedido.Text;
                c.Aceptacion_pedido = txtAceptacion_pedido.Text;

                n = bLPedido.Actualizar(c);
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
                lista = bLPedido.Listar();
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
                    c = bLPedido.TraerPorId((int)dgvDatos[0, dgvDatos.
                        CurrentRow.Index].Value);
                    
                    txtIdcliente.Text = Convert.ToString(c.Idcliente);
                    txtIdvendedor.Text = Convert.ToString(c.Idvendedor);
                    txtValor_pedido.Text = Convert.ToString(c.Total_pedido);
                    txtFecha_pedido.Text = c.Fecha_pedido;
                    txtAceptacion_pedido.Text = c.Aceptacion_pedido;                   
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

                c = bLPedido.TraerPorId((int)dgvDatos[0, dgvDatos.
                    CurrentRow.Index].Value);
                DialogResult rpta =
                    MessageBox.Show("Desea eliminar el registro", "Eliminar",
                    MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                if (rpta == System.Windows.Forms.DialogResult.Yes)
                {
                    int n = bLPedido.Eliminar(c.Idpedido);
                    if (n > 0)
                    {
                        MessageBox.Show("Registro eliminado", "Aviso",
                            MessageBoxButtons.OK, MessageBoxIcon.Information);
                        lista = bLPedido.Listar();
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

        private void pictureBox1_Click(object sender, EventArgs e)
       
        {
            
            program.operacion = (int)dgvDatos[0, dgvDatos.CurrentRow.Index].Value;

            if (dgvDatos.RowCount > 0)
            {
                
                
                DialogResult rpta =
                    MessageBox.Show("Desea agregar  articulos", "Agregar",
                    MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                if (rpta == System.Windows.Forms.DialogResult.Yes)
                {
                    
                    if (rpta > 0)
                    {
                       
                        FormDetalle_pedido Frm = new FormDetalle_pedido();
                        Frm.Show();

                      
                    }
                    else
                    {
                        MessageBox.Show("Error al eliminar", "Aviso",
                            MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }
                Close();
            }
        }
    }
}
