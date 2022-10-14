﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Tienda.Entidades;
using Tienda.Datos;


namespace Tienda.Negocio
{
   public  class BLCategoria
    {
        public List<Categoria> Listar()
        {
            DAOCategoria daCategoria = new DAOCategoria();
            return daCategoria.Listar();
        }

        public Categoria TraerPorId(int Id)
        {
            DAOCategoria daCategoria = new DAOCategoria();
            return daCategoria.TraerPorId(Id);
        }

        public int Insertar(Categoria Categoria)
        {
            DAOCategoria daCategoria = new DAOCategoria();
            return daCategoria.Insertar(Categoria);
        }

        public int Actualizar(Categoria Categoria)
        {
            DAOCategoria daCategoria = new DAOCategoria();
            return daCategoria.Actualizar(Categoria);
        }

        public int Eliminar(int Id)
        {
            DAOCategoria daCategoria = new DAOCategoria();
            return daCategoria.Eliminar(Id);
        }

       
    }
}
