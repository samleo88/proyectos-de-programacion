﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TiendaWindows
{
    static class program
    {
        public static string vacceso = "";
        public static int operacion = 0;
        /// <summary>
        /// Punto de entrada principal para la aplicación.
        /// </summary
        /// 
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new FormLogin());
        }
    }
}
