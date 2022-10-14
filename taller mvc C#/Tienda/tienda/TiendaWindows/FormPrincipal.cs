using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TiendaWindows
{
    public partial class FormPrincipal : Form
    {
        public FormPrincipal()
        {
            InitializeComponent();
            ActivarButton(program.vacceso);
            
        }
        private void ActivarButton(string x)
        {
            if (program.vacceso == "1")
            {
                articuloToolStripMenuItem1.Enabled = true;
                categoriaToolStripMenuItem1.Enabled = true;
                clienteToolStripMenuItem.Enabled = true;
                pedidoToolStripMenuItem1.Enabled = true;
                vendedorToolStripMenuItem1.Enabled = true;
            }
            else {
                articuloToolStripMenuItem1.Enabled = false;
                categoriaToolStripMenuItem1.Enabled = false;
                clienteToolStripMenuItem.Enabled = true;
                pedidoToolStripMenuItem1.Enabled = true;
                vendedorToolStripMenuItem1.Enabled = false;
            }
        }

        

        private void FormPrincipal_Load(object sender, EventArgs e)
        {

        }


        private void clienteToolStripMenuItem_Click(object sender, EventArgs e)
        {
            FormCliente Frm = new FormCliente();
            Frm.Show();
        }

        private void vendedorToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            FormVendedor Frm = new FormVendedor();
            Frm.Show();
        }

        private void categoriaToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            FormCategorias Frm = new FormCategorias();
            Frm.Show();
        }

        private void articuloToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            FormArticulo Frm = new FormArticulo();
            Frm.Show();
        }

        private void pedidoToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            FormPedido Frm = new FormPedido();
            Frm.Show();
        }

        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
