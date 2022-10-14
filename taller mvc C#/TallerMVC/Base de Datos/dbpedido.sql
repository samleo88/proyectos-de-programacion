
/****** Object:  Database [dbventas]    Script Date: 09/01/2016 21:38:45 ******/
CREATE DATABASE [dbpedido]

ALTER DATABASE [dbpedido] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [dbpedido].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [dbpedido] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [dbpedido] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [dbpedido] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [dbpedido] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [dbpedido] SET ARITHABORT OFF 
GO
ALTER DATABASE [dbpedido] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [dbpedido] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [dbpedido] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [dbpedido] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [dbpedido] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [dbpedido] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [dbpedido] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [dbpedido] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [dbpedido] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [dbpedido] SET  DISABLE_BROKER 
GO
ALTER DATABASE [dbpedido] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [dbpedido] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [dbpedido] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [dbpedido] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [dbpedido] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [dbpedido] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [dbpedido] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [dbpedido] SET RECOVERY FULL 
GO
ALTER DATABASE [dbpedido] SET  MULTI_USER 
GO
ALTER DATABASE [dbpedido] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [dbpedido] SET DB_CHAINING OFF 
GO


USE [dbpedido]
GO
/****** Object:  Table [dbo].[articulo]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[articulo](
	[idarticulo] [int] IDENTITY(1,1) NOT NULL,
	[codigo] [varchar](50) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[descripcion] [varchar](1024) NULL,
	[imagen] [image] NULL,
	[idcategoria] [int] NOT NULL,
	[idpresentacion] [int] NOT NULL,
 CONSTRAINT [PK_articulo] PRIMARY KEY CLUSTERED 
(
	[idarticulo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[categoria]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[categoria](
	[idcategoria] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[descripcion] [varchar](256) NULL,
 CONSTRAINT [PK_categoria] PRIMARY KEY CLUSTERED 
(
	[idcategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO


CREATE TABLE [dbo].[presentacion](
	[idpresentacion] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[descripcion] [varchar](256) NULL,
 CONSTRAINT [PK_presentacion] PRIMARY KEY CLUSTERED 
(
	[idpresentacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[cliente]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[cliente](
	[idcliente] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellidos] [varchar](40) NULL,
	[sexo] [varchar](1) NULL,
	[fecha_nacimiento] [date] NULL,
	[tipo_documento] [varchar](20) NOT NULL,
	[num_documento] [varchar](11) NOT NULL,
	[direccion] [varchar](100) NULL,
	[telefono] [varchar](10) NULL,
	[email] [varchar](50) NULL,
 CONSTRAINT [PK_cliente] PRIMARY KEY CLUSTERED 
(
	[idcliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO


/****** Object:  Table [dbo].[detalle_ingreso]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[detalle_articulo](
	[iddetalle_articulo] [int] IDENTITY(1,1) NOT NULL,
	[idarticulo] [int] NOT NULL,
	[precio_compra] [money] NOT NULL,
	[precio_venta] [money] NOT NULL,
	[stock_inicial] [int] NOT NULL,
	[stock_actual] [int] NOT NULL,
	[fecha_produccion] [date] NOT NULL,
	[fecha_vencimiento] [date] NOT NULL,
 CONSTRAINT [PK_detalle_articulo] PRIMARY KEY CLUSTERED 
(
	[iddetalle_articulo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[vendedor](
	[idvendedor] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](20) NOT NULL,
	[apellidos] [varchar](40) NOT NULL,
	[sexo] [varchar](1) NOT NULL,
	[fecha_nac] [date] NOT NULL,
	[num_documento] [varchar](8) NOT NULL,
	[direccion] [varchar](100) NULL,
	[telefono] [varchar](10) NULL,
	[email] [varchar](50) NULL,
	[acceso] [varchar](20) NOT NULL,
	[usuario] [varchar](20) NOT NULL,
	[password] [varchar](20) NOT NULL,
 CONSTRAINT [PK_vendedor] PRIMARY KEY CLUSTERED 
(
	[idvendedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[detalle_pedido](
	[iddetalle_pedido] [int] IDENTITY(1,1) NOT NULL,
	[idpedido] [int] NOT NULL,
	[iddetalle_articulo] [int] NOT NULL,
	[cantidad] [int] NOT NULL,
	[precio_venta] [money] NOT NULL,
	[descuento] [money] NOT NULL,
 CONSTRAINT [PK_detalle_pedido] PRIMARY KEY CLUSTERED 
(
	[iddetalle_pedido] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[pedido](
	[idpedido] [int] IDENTITY(1,1) NOT NULL,
	[idcliente] [int] NOT NULL,
	[idvendedor] [int] NOT NULL,
	[fecha] [date] NOT NULL,
	[tipo_comprobante] [varchar](20) NOT NULL,
	[serie] [varchar](4) NOT NULL,
	[correlativo] [varchar](7) NOT NULL,
	[igv] [decimal](4, 2) NOT NULL,
 CONSTRAINT [PK_pedido] PRIMARY KEY CLUSTERED 
(
	[idpedido] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[articulo]  WITH CHECK ADD  CONSTRAINT [FK_articulo_categoria] FOREIGN KEY([idcategoria])
REFERENCES [dbo].[categoria] ([idcategoria])
GO
ALTER TABLE [dbo].[articulo] CHECK CONSTRAINT [FK_articulo_categoria]
GO
ALTER TABLE [dbo].[articulo]  WITH CHECK ADD  CONSTRAINT [FK_articulo_presentacion] FOREIGN KEY([idpresentacion])
REFERENCES [dbo].[presentacion] ([idpresentacion])
GO
ALTER TABLE [dbo].[articulo] CHECK CONSTRAINT [FK_articulo_presentacion]
GO
ALTER TABLE [dbo].[detalle_articulo]  WITH CHECK ADD  CONSTRAINT [FK_detalle_articulo_articulo] FOREIGN KEY([idarticulo])
REFERENCES [dbo].[articulo] ([idarticulo])
GO
ALTER TABLE [dbo].[detalle_articulo] CHECK CONSTRAINT [FK_detalle_articulo_articulo]
GO



ALTER TABLE [dbo].[detalle_pedido]  WITH CHECK ADD  CONSTRAINT [FK_detalle_pedido_detalle_articulo] FOREIGN KEY([iddetalle_articulo])
REFERENCES [dbo].[detalle_articulo] ([iddetalle_articulo])
GO
ALTER TABLE [dbo].[detalle_pedido] CHECK CONSTRAINT [FK_detalle_pedido_detalle_articulo]
GO
ALTER TABLE [dbo].[detalle_pedido]  WITH CHECK ADD  CONSTRAINT [FK_detalle_pedido_pedido] FOREIGN KEY([idpedido])
REFERENCES [dbo].[pedido] ([idpedido])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[detalle_pedido] CHECK CONSTRAINT [FK_detalle_pedido_pedido]
GO


ALTER TABLE [dbo].[pedido]  WITH CHECK ADD  CONSTRAINT [FK_pedido_cliente] FOREIGN KEY([idcliente])
REFERENCES [dbo].[cliente] ([idcliente])
GO
ALTER TABLE [dbo].[pedido] CHECK CONSTRAINT [FK_pedido_cliente]
GO
ALTER TABLE [dbo].[pedido]  WITH CHECK ADD  CONSTRAINT [FK_pedido_vendedor] FOREIGN KEY([idvendedor])
REFERENCES [dbo].[vendedor] ([idvendedor])
GO
ALTER TABLE [dbo].[pedido] CHECK CONSTRAINT [FK_pedido_vendedor]
GO

/****** Object:  StoredProcedure [dbo].[spbuscar_articulo_nombre]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spbuscar_articulo_nombre]
@textobuscar varchar(50)
as
SELECT dbo.articulo.idarticulo, dbo.articulo.codigo, dbo.articulo.nombre,
dbo.articulo.descripcion, dbo.articulo.imagen, dbo.articulo.idcategoria,
dbo.categoria.nombre AS Categoria, dbo.articulo.idpresentacion, 
dbo.presentacion.nombre AS Presentacion
FROM dbo.articulo INNER JOIN dbo.categoria 
ON dbo.articulo.idcategoria = dbo.categoria.idcategoria 
INNER JOIN dbo.presentacion 
ON dbo.articulo.idpresentacion = dbo.presentacion.idpresentacion
where dbo.articulo.nombre like @textobuscar + '%'
order by dbo.articulo.idarticulo desc

GO
/****** Object:  StoredProcedure [dbo].[spbuscar_categoria]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[spbuscar_categoria]
@textobuscar varchar(50)
as
select * from categoria
where nombre like @textobuscar + '%' --Alt +39
GO
/****** Object:  StoredProcedure [dbo].[spbuscar_cliente_apellidos]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spbuscar_cliente_apellidos]
@textobuscar varchar(50)
as
select * from cliente
where apellidos like @textobuscar + '%'

GO
/****** Object:  StoredProcedure [dbo].[spbuscar_cliente_num_documento]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spbuscar_cliente_num_documento]
@textobuscar varchar(50)
as
select * from cliente
where num_documento like @textobuscar + '%'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spbuscar_presentacion_nombre]
@textobuscar varchar(50)
as
select * from presentacion
where nombre like @textobuscar + '%' --Alt + 39

GO



SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spbuscar_vendedor_apellidos]
@textobuscar varchar(50)
as
select * from vendedor
where apellidos like @textobuscar +'%'
order by apellidos asc

GO
/****** Object:  StoredProcedure [dbo].[spbuscar_trabajador_num_documento]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spbuscar_vendedor_num_documento]
@textobuscar varchar(50)
as
select * from vendedor
where num_documento like @textobuscar +'%'
order by apellidos asc

GO

/*ya fue ejecutado hasta este punto*/
/*ya fue ejecutado hasta este punto*/
/*ya fue ejecutado hasta este punto*/
/*ya fue ejecutado hasta este punto*/

/****** Object:  StoredProcedure [dbo].[spbuscar_venta_fecha]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[spbuscar_pedido_fecha]
@textobuscar varchar(50),
@textobuscar2 varchar(50)
as
select v.idpedido,
(t.apellidos+' '+t.nombre) as vendedor,
(c.apellidos+' '+c.nombre) as Cliente,
v.fecha,v.tipo_comprobante,v.serie,v.correlativo,
sum((d.cantidad*d.precio_venta)-d.descuento) as Total,v.igv as Impuesto
from detalle_pedido d inner join pedido v
on d.idpedido=v.idpedido
inner join cliente c
on v.idcliente=c.idcliente
inner join vendedor t
on v.idvendedor=t.idvendedor
group by v.idpedido,
(t.apellidos+' '+t.nombre),
(c.apellidos+' '+c.nombre),
v.fecha,v.tipo_comprobante,v.serie,v.correlativo,v.igv
having v.fecha>=@textobuscar and v.fecha<=@textobuscar2

GO
/****** Object:  StoredProcedure [dbo].[spbuscararticulo_venta_codigo]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spbuscararticulo_pedido_codigo]
@textobuscar varchar(50)
as
select d.iddetalle_articulo,a.Codigo,a.Nombre,
c.nombre as Categoria,p.nombre as Presentacion,
d.stock_actual,d.precio_compra,d.precio_venta,
d.fecha_vencimiento
from articulo a inner join categoria c
on a.idcategoria=c.idcategoria
inner join presentacion p
on a.idpresentacion=p.idpresentacion
inner join detalle_articulo d
on a.idarticulo=d.idarticulo
where a.codigo=@textobuscar
and d.stock_actual>0


GO
/****** Object:  StoredProcedure [dbo].[spbuscararticulo_venta_nombre]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spbuscararticulo_pedido_nombre]
@textobuscar varchar(50)
as
select d.iddetalle_articulo,a.Codigo,a.Nombre,
c.nombre as Categoria,p.nombre as Presentacion,
d.stock_actual,d.precio_compra,d.precio_venta,
d.fecha_vencimiento
from articulo a inner join categoria c
on a.idcategoria=c.idcategoria
inner join presentacion p
on a.idpresentacion=p.idpresentacion
inner join detalle_articulo d
on a.idarticulo=d.idarticulo
where a.nombre like @textobuscar + '%'
and d.stock_actual>0


GO
/****** Object:  StoredProcedure [dbo].[spdisminuir_stock]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spdisminuir_stock]
@iddetalle_ingreso int,
@cantidad int
as
update detalle_articulo set stock_actual=stock_actual-@cantidad
where iddetalle_articulo=@iddetalle_ingreso

GO
/****** Object:  StoredProcedure [dbo].[speditar_articulo]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[speditar_articulo]
@idarticulo int,
@codigo varchar(50),
@nombre varchar(50),
@descripcion varchar(1024),
@imagen image,
@idcategoria int,
@idpresentacion int
as
update articulo set codigo=@codigo,nombre=@nombre,descripcion=@descripcion,
imagen=@imagen,idcategoria=@idcategoria,idpresentacion=@idpresentacion
where idarticulo=@idarticulo

GO
/****** Object:  StoredProcedure [dbo].[speditar_categoria]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Procedimiento Editar
create proc [dbo].[speditar_categoria]
@idcategoria int,
@nombre varchar(50),
@descripcion varchar(256)
as
update categoria set nombre=@nombre,
descripcion=@descripcion
where idcategoria=@idcategoria

GO
/****** Object:  StoredProcedure [dbo].[speditar_cliente]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[speditar_cliente]
@idcliente int,
@nombre varchar(50),
@apellidos varchar(40),
@sexo varchar(1),
@fecha_nacimiento date,
@tipo_documento varchar(20),
@num_documento varchar(11),
@direccion varchar(100),
@telefono varchar(10),
@email varchar(50)
as
update cliente set nombre=@nombre,apellidos=@apellidos,sexo=@sexo,
fecha_nacimiento=@fecha_nacimiento,tipo_documento=@tipo_documento,
num_documento=@num_documento,direccion=@direccion,
telefono=@telefono,email=@email
where idcliente=@idcliente

GO
/****** Object:  StoredProcedure [dbo].[speditar_presentacion]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[speditar_presentacion]
@idpresentacion int,
@nombre varchar(50),
@descripcion varchar(256)
as
update presentacion set nombre=@nombre, descripcion=@descripcion
where idpresentacion=@idpresentacion

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[speditar_vendedor]
@idvendedor int,
@nombre varchar(20),
@apellidos varchar(40),
@sexo varchar(1),
@fecha_nacimiento date,
@num_documento varchar(8),
@direccion varchar(100),
@telefono varchar(10),
@email varchar(50),
@acceso varchar(20),
@usuario varchar(20),
@password varchar(20)
as
update vendedor set nombre=@nombre,apellidos=@apellidos,
sexo=@sexo,fecha_nac=@fecha_nacimiento,num_documento=@num_documento,
direccion=@direccion,telefono=@telefono,email=@email,
acceso=@acceso,usuario=@usuario,password=@password
where idvendedor=@idvendedor

GO
/****** Object:  StoredProcedure [dbo].[speliminar_articulo]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[speliminar_articulo]
@idarticulo int
as
delete from articulo
where idarticulo=@idarticulo

GO
/****** Object:  StoredProcedure [dbo].[speliminar_categoria]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Procedimiento Eliminar
create proc [dbo].[speliminar_categoria]
@idcategoria int
as
delete from categoria
where idcategoria=@idcategoria

GO
/****** Object:  StoredProcedure [dbo].[speliminar_cliente]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[speliminar_cliente]
@idcliente int
as
delete from cliente
where idcliente=@idcliente

GO
/****** Object:  StoredProcedure [dbo].[speliminar_presentacion]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[speliminar_presentacion]
@idpresentacion int
as
delete from presentacion
where idpresentacion=@idpresentacion

GO
/****** Object:  StoredProcedure [dbo].[speliminar_proveedor]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[speliminar_vendedor]
@idvendedor int
as
delete from vendedor
where idvendedor=@idvendedor

GO
/****** Object:  StoredProcedure [dbo].[speliminar_venta]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[speliminar_pedido]
@idpedido int
as
delete from pedido
where idpedido=@idpedido

GO
/****** Object:  StoredProcedure [dbo].[spinsertar_articulo]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spinsertar_articulo]
@idarticulo int output,
@codigo varchar(50),
@nombre varchar(50),
@descripcion varchar(1024),
@imagen image,
@idcategoria int,
@idpresentacion int
as
insert into articulo (codigo,nombre,descripcion,imagen,idcategoria,idpresentacion)
values (@codigo,@nombre,@descripcion,@imagen,@idcategoria,@idpresentacion)

GO
/****** Object:  StoredProcedure [dbo].[spinsertar_categoria]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Procedimiento Insertar
create proc [dbo].[spinsertar_categoria]
@idcategoria int output,
@nombre varchar(50),
@descripcion varchar(256)
as
insert into categoria (nombre,descripcion)
values (@nombre,@descripcion)

GO
/****** Object:  StoredProcedure [dbo].[spinsertar_cliente]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spinsertar_cliente]
@idcliente int output,
@nombre varchar(50),
@apellidos varchar(40),
@sexo varchar(1),
@fecha_nacimiento date,
@tipo_documento varchar(20),
@num_documento varchar(11),
@direccion varchar(100),
@telefono varchar(10),
@email varchar(50)
as 
insert into cliente (nombre,apellidos,sexo,fecha_nacimiento,
tipo_documento,num_documento,direccion,telefono,email)
values (@nombre,@apellidos,@sexo,@fecha_nacimiento,
@tipo_documento,@num_documento,@direccion,@telefono,@email)

GO
/****** Object:  StoredProcedure [dbo].[spinsertar_detalle_ingreso]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spinsertar_detalle_articulo]
@iddetalle_articulo int output,
@idarticulo int,
@precio_compra money,
@precio_venta money,
@stock_inicial int,
@stock_actual int,
@fecha_produccion date,
@fecha_vencimiento date
as
insert into detalle_articulo(idarticulo,precio_compra,
precio_venta,stock_inicial,stock_actual,fecha_produccion,
fecha_vencimiento)
values (@idarticulo,@precio_compra,
@precio_venta,@stock_inicial,@stock_actual,@fecha_produccion,
@fecha_vencimiento)

GO
/****** Object:  StoredProcedure [dbo].[spinsertar_detalle_venta]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spinsertar_detalle_pedido]
@iddetalle_pedido int output,
@idpedido int,
@iddetalle_articulo int,
@cantidad int,
@precio_venta money,
@descuento money
as
insert into detalle_pedido(idpedido,iddetalle_articulo,cantidad,
precio_venta,descuento)
values (@idpedido,@iddetalle_articulo,@cantidad,
@precio_venta,@descuento)

GO

/****** Object:  StoredProcedure [dbo].[spinsertar_presentacion]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spinsertar_presentacion]
@idpresentacion int output,
@nombre varchar(50),
@descripcion varchar(256)
as
insert into presentacion (nombre,descripcion)
values (@nombre,@descripcion)

GO
/****** Object:  StoredProcedure [dbo].[spinsertar_trabajador]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- Insertar
create proc [dbo].[spinsertar_vendedor]
@idvendedor int output,
@nombre varchar(20),
@apellidos varchar(40),
@sexo varchar(1),
@fecha_nacimiento date,
@num_documento varchar(8),
@direccion varchar(100),
@telefono varchar(10),
@email varchar(50),
@acceso varchar(20),
@usuario varchar(20),
@password varchar(20)
as
insert into vendedor(nombre,apellidos,sexo,fecha_nac,
num_documento,direccion,telefono,email,acceso,usuario,password)
values (@nombre,@apellidos,@sexo,@fecha_nacimiento,
@num_documento,@direccion,@telefono,@email,@acceso,@usuario,
@password)

GO
/****** Object:  StoredProcedure [dbo].[spinsertar_venta]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spinsertar_pedido]
@idpedido int=null output,
@idcliente int,
@idvendedor int,
@fecha date,
@tipo_comprobante varchar(20),
@serie varchar(4),
@correlativo varchar(7),
@igv decimal(4,2)
as
insert into pedido (idcliente,idvendedor,fecha,tipo_comprobante,
serie,correlativo,igv)
values (@idcliente,@idvendedor,@fecha,@tipo_comprobante,
@serie,@correlativo,@igv)
--Obtenemos el código autogenerado
set @idpedido=@@IDENTITY

GO
/****** Object:  StoredProcedure [dbo].[splogin]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[splogin]
@usuario varchar(20),
@password varchar(20)
as
select idvendedor,apellidos,nombre,acceso
from vendedor
where usuario=@usuario and password=@password

GO
/****** Object:  StoredProcedure [dbo].[spmostrar_articulo]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spmostrar_articulo]
as
SELECT top 100 dbo.articulo.idarticulo, dbo.articulo.codigo, dbo.articulo.nombre,
dbo.articulo.descripcion, dbo.articulo.imagen, dbo.articulo.idcategoria,
dbo.categoria.nombre AS Categoria, dbo.articulo.idpresentacion, 
dbo.presentacion.nombre AS Presentacion
FROM dbo.articulo INNER JOIN dbo.categoria 
ON dbo.articulo.idcategoria = dbo.categoria.idcategoria 
INNER JOIN dbo.presentacion 
ON dbo.articulo.idpresentacion = dbo.presentacion.idpresentacion
order by dbo.articulo.idarticulo desc

GO
/****** Object:  StoredProcedure [dbo].[spmostrar_categoria]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spmostrar_categoria]
as
select top 200 * from categoria
order by idcategoria desc

GO
/****** Object:  StoredProcedure [dbo].[spmostrar_cliente]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spmostrar_cliente]
as
select top 100 * from cliente
order by apellidos asc

GO
/****** Object:  StoredProcedure [dbo].[spmostrar_detalle_ingreso]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spmostrar_detalle_articulo]
@textobuscar int
as
select d.idarticulo,a.nombre as Articulo,d.precio_compra,
d.precio_venta,d.stock_inicial,d.fecha_produccion,
d.fecha_vencimiento,(d.stock_inicial*d.precio_compra) as Subtotal
from detalle_articulo d inner join articulo a
on d.idarticulo=a.idarticulo
GO
/****** Object:  StoredProcedure [dbo].[spmostrar_detalle_venta]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spmostrar_detalle_pedido]
@textobuscar int
as
select d.iddetalle_articulo,a.nombre as Artículo,
d.cantidad,d.precio_venta,d.descuento,
((d.precio_venta*d.cantidad)-d.descuento) as Subtotal
from detalle_pedido d inner join detalle_articulo di
on d.iddetalle_articulo=di.iddetalle_articulo
inner join articulo a
on di.idarticulo=a.idarticulo
where d.idpedido=@textobuscar
GO
/****** Object:  StoredProcedure [dbo].[spmostrar_presentacion]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spmostrar_presentacion]
as
select top 100 * from presentacion
order by idpresentacion desc

GO
/****** Object:  StoredProcedure [dbo].[spmostrar_trabajador]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spmostrar_vendedor]
as
select top 100 * from vendedor
order by apellidos asc

GO
/****** Object:  StoredProcedure [dbo].[spmostrar_venta]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[spmostrar_pedido]
as
select top 100 v.idpedido,
(t.apellidos+' '+t.nombre) as vendedor,
(c.apellidos+' '+c.nombre) as Cliente,
v.fecha,v.tipo_comprobante,v.serie,v.correlativo,
sum((d.cantidad*d.precio_venta)-d.descuento) as Total,v.igv as Impuesto
from detalle_pedido d inner join pedido v
on d.idpedido=v.idpedido
inner join cliente c
on v.idcliente=c.idcliente
inner join vendedor t
on v.idvendedor=t.idvendedor
group by v.idpedido,
(t.apellidos+' '+t.nombre),
(c.apellidos+' '+c.nombre),
v.fecha,v.tipo_comprobante,v.serie,v.correlativo,v.igv
order by v.idpedido desc

GO
/****** Object:  StoredProcedure [dbo].[spreporte_factura]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spreporte_factura]
@idpedido int
as
select 
v.idpedido,(t.apellidos+' '+t.nombre) as vendedor,
(c.apellidos+' '+c.nombre) as Cliente,
c.direccion,c.telefono,c.num_documento,
v.fecha,v.tipo_comprobante,v.serie,v.correlativo,
v.igv,a.nombre,dv.precio_venta,dv.cantidad,dv.descuento,
(dv.cantidad*dv.precio_venta-dv.descuento) as Total_Parcial
 from detalle_pedido dv inner join detalle_articulo di
on dv.iddetalle_articulo=di.iddetalle_articulo
inner join articulo a
on a.idarticulo=di.idarticulo
inner join pedido v
on v.idpedido=dv.idpedido
inner join cliente c
on v.idcliente=c.idcliente
inner join vendedor t
on t.idvendedor=v.idvendedor
where v.idpedido=@idpedido

GO
/****** Object:  StoredProcedure [dbo].[spstock_articulos]    Script Date: 09/01/2016 21:38:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spstock_articulos]
as
SELECT dbo.articulo.codigo, dbo.articulo.nombre,
dbo.categoria.nombre AS Categoria,
sum(dbo.detalle_articulo.stock_inicial) as Cantidad_Ingreso,
sum(dbo.detalle_articulo.stock_actual) as Cantidad_Stock,
(sum(dbo.detalle_articulo.stock_inicial)-
sum(dbo.detalle_articulo.stock_actual)) as Cantidad_Venta
FROM dbo.articulo INNER JOIN dbo.categoria 
ON dbo.articulo.idcategoria = dbo.categoria.idcategoria 
INNER JOIN dbo.detalle_articulo 
ON dbo.articulo.idarticulo = dbo.detalle_articulo.idarticulo 
group by dbo.articulo.codigo, dbo.articulo.nombre,
dbo.categoria.nombre
GO

