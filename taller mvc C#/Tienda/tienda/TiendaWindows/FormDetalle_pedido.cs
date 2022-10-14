﻿using System;
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
    public partial class FormDetalle_pedido : Form
    {
        /*List<Articulo> lista = null;
        BLArticulo bLArticulo = new BLArticulo();
        Articulo c;
        bool _nuevo = false;*/
        List<Detalle_pedido> lista = null;
        BLDetalle_pedido bLDetalle_Pedido = new BLDetalle_pedido();
        BLPedido bLPedido = new BLPedido();

        Detalle_pedido c;
        Pedido b;
        bool _nuevo = false;
        public FormDetalle_pedido()
        {
            InitializeComponent();
            ActivarControlDatos(gbDatos, false);
            label4.Text = program.operacion.ToString();
            
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
                lista = bLDetalle_Pedido.listarID(int.Parse(label4.Text));

            }
            if (lista.Count > 0)
            {
                dgvDatos.Rows.Clear();
                for (int i = 0; i < lista.Count; i++)
                {
                    dgvDatos.Rows.Add(lista[i].IdDetalle, lista[i].IdPedido,lista[i].IdArticulo, lista[i].Nombre,
                        lista[i].Precio_unitario, lista[i].Cantidad, lista[i].Valor_total);
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
            txtPrecio_unitario.Focus();
        }

        private void btnGrabar_Click(object sender, EventArgs e)
        {
            //label5.Text = (decimal.Parse(txtPrecio_unitario.Text) * decimal.Parse(txtCantidad.Text)).ToString();
            int n = -1;
            if (_nuevo)
            {
                c = new Detalle_pedido(0,
                  int.Parse(label4.Text),
                    int.Parse(txtIdArticulo.Text),
                    txtIdArticulo.Text,
                    decimal.Parse(txtPrecio_unitario.Text),
                  decimal.Parse(label5.Text = (decimal.Parse(txtPrecio_unitario.Text) * decimal.Parse(txtCantidad.Text)).ToString()),
                   int.Parse(txtCantidad.Text)
                   
                  );
                n = bLDetalle_Pedido.Insertar(c);
                
            }
            else
            {


                c.IdPedido= int.Parse(label4.Text);
                c.IdArticulo = int.Parse(txtIdArticulo.Text);
                c.Precio_unitario = decimal.Parse(txtPrecio_unitario.Text);
                c.Cantidad = int.Parse(txtCantidad.Text);
                c.Valor_total = decimal.Parse(txtCantidad.Text)*decimal.Parse(txtPrecio_unitario.Text);
                        
               n = bLDetalle_Pedido.Actualizar(c);
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
                lista = bLDetalle_Pedido.listarID(int.Parse(label4.Text));
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
                    c = bLDetalle_Pedido.TraerPorId((int)dgvDatos[0, dgvDatos.
                        CurrentRow.Index].Value);
                    label4.Text = Convert.ToString(c.IdPedido);
                    txtIdArticulo.Text = Convert.ToString(c.IdArticulo);
                    txtPrecio_unitario.Text = Convert.ToString(c.Precio_unitario);
                    txtCantidad.Text = Convert.ToString(c.Cantidad);
                    label5.Text = Convert.ToString(c.Precio_unitario*c.Cantidad);
                  
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

                c = bLDetalle_Pedido.TraerPorId((int)dgvDatos[0, dgvDatos.
                    CurrentRow.Index].Value);
                DialogResult rpta =
                    MessageBox.Show("Desea eliminar el registro", "Eliminar",
                    MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                if (rpta == System.Windows.Forms.DialogResult.Yes)
                {
                    int n = bLDetalle_Pedido.Eliminar(c);
                    if (n > 0)
                    {
                        MessageBox.Show("Registro eliminado", "Aviso",
                            MessageBoxButtons.OK, MessageBoxIcon.Information);
                        lista = bLDetalle_Pedido.listarID(int.Parse(label4.Text));
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
            FormPedido Frm = new FormPedido();
            Frm.Show();
            Close();
        }

       /* private void FormDetalle_pedido_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'tiendaDataSet.Pedido' Puede moverla o quitarla según sea necesario.
            this.pedidoTableAdapter.Fill(this.tiendaDataSet.Pedido);

        }*/
    }
}
