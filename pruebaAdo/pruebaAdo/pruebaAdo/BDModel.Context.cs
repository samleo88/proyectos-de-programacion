﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código se generó a partir de una plantilla.
//
//     Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//     Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace pruebaAdo
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    using System.Data.Entity.Core.Objects;
    using System.Linq;
    
    public partial class PruebaEntities1 : DbContext
    {
        public PruebaEntities1()
            : base("name=PruebaEntities1")
        {
        }
    
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            throw new UnintentionalCodeFirstException();
        }
    
        public virtual DbSet<Cliente> Cliente { get; set; }
    
        public virtual int ActualizarCliente(Nullable<int> idcliente, string nombre, string apellido, string direccion)
        {
            var idclienteParameter = idcliente.HasValue ?
                new ObjectParameter("Idcliente", idcliente) :
                new ObjectParameter("Idcliente", typeof(int));
    
            var nombreParameter = nombre != null ?
                new ObjectParameter("Nombre", nombre) :
                new ObjectParameter("Nombre", typeof(string));
    
            var apellidoParameter = apellido != null ?
                new ObjectParameter("Apellido", apellido) :
                new ObjectParameter("Apellido", typeof(string));
    
            var direccionParameter = direccion != null ?
                new ObjectParameter("Direccion", direccion) :
                new ObjectParameter("Direccion", typeof(string));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("ActualizarCliente", idclienteParameter, nombreParameter, apellidoParameter, direccionParameter);
        }
    
        public virtual int EliminarCliente(Nullable<int> iD)
        {
            var iDParameter = iD.HasValue ?
                new ObjectParameter("ID", iD) :
                new ObjectParameter("ID", typeof(int));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("EliminarCliente", iDParameter);
        }
    
        public virtual int InsertarCliente(string nombre, string apellido, string direccion)
        {
            var nombreParameter = nombre != null ?
                new ObjectParameter("Nombre", nombre) :
                new ObjectParameter("Nombre", typeof(string));
    
            var apellidoParameter = apellido != null ?
                new ObjectParameter("Apellido", apellido) :
                new ObjectParameter("Apellido", typeof(string));
    
            var direccionParameter = direccion != null ?
                new ObjectParameter("Direccion", direccion) :
                new ObjectParameter("Direccion", typeof(string));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("InsertarCliente", nombreParameter, apellidoParameter, direccionParameter);
        }
    
        public virtual ObjectResult<ListarClientes_Result> ListarClientes()
        {
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction<ListarClientes_Result>("ListarClientes");
        }
    
        public virtual ObjectResult<TraerClientePorId_Result> TraerClientePorId(Nullable<int> iD)
        {
            var iDParameter = iD.HasValue ?
                new ObjectParameter("ID", iD) :
                new ObjectParameter("ID", typeof(int));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction<TraerClientePorId_Result>("TraerClientePorId", iDParameter);
        }
    }
}