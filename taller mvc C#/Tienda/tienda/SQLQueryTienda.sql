USE [master]
GO

CREATE DATABASE [Tienda]

USE [Tienda]


/****** Object:  Table [dbo].[categoria]    ******/

CREATE TABLE Categoria(
	Idcategoria int IDENTITY(1,1) NOT NULL,
	Codigo varchar(10)NOT NULL,
	Nombre varchar(50) NOT NULL,
	Observacion varchar(256) NULL,
 CONSTRAINT [PK_Categoria] PRIMARY KEY CLUSTERED 
(
	Idcategoria ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
/****** insertar registros a la tabla categoria*****/

INSERT INTO "Categoria" ( "Codigo", "Nombre","Observacion")
VALUES (2,'Aseo', 'productos liquidos');

/**** para mostrar todos los registros de la tabla categoria****/
 select * from Categoria



/*****procedmiento de traer listado de los registros en  tabla categoria *****/ 
 
CREATE PROCEDURE ListarCategorias
AS
SELECT IdCategoria [Id],
    ISNULL(Codigo,'') [Codigo],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Observacion,'')[Observacion]
FROM Categoria
GO
/*****procedmiento de traer listado por id de los registros en  tabla categoria *****/ 
CREATE PROCEDURE TraerCategoriaPorId
@ID int
AS
SELECT IdCategoria [Id],
    ISNULL(Codigo,'') [Codigo],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Observacion,'')[Observacion]
FROM Categoria
WHERE IdCategoria = @ID
GO
 /*****procedmiento de insertar en tabla categoria*****/ 
CREATE PROCEDURE InsertarCategoria
    @CODIGO VARCHAR(8),
    @NOMBRE VARCHAR(100),
    @OBSERVACION TEXT
AS
INSERT INTO Categoria(Codigo,Nombre,Observacion)
VALUES(@CODIGO,@NOMBRE,@OBSERVACION)
GO
 /*****procedmiento de actualizar en tabla categoria*****/ 
CREATE PROCEDURE ActualizarCategoria
    @ID INT,
    @CODIGO VARCHAR(8),
    @NOMBRE VARCHAR(100),
    @OBSERVACION TEXT
AS
UPDATE Categoria SET Codigo = @CODIGO,
    Nombre = @NOMBRE, Observacion = @OBSERVACION
WHERE IdCategoria = @ID
GO
 /*****procedmiento de eliminar en  tabla categoria*****/
CREATE PROCEDURE EliminarCategoria
    @ID INT
AS
DELETE FROM Categoria
WHERE IdCategoria = @ID

/********* crear tabla cliente****/

CREATE TABLE Cliente(
	Idcliente int IDENTITY(1,1) NOT NULL,
	Nombre varchar(20) NOT NULL,
	Apellido varchar(40)NULL,
	Sexo varchar(1) NULL,
	Tipo_Documento varchar(20)NOT NULL,
    Num_Documento varchar(10)NOT NULL,
    Direccion varchar(20)NULL,
    Telefono varchar(20)NULL,
    Email varchar(20)NULL,   
 CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
(
	Idcliente ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
/****** insertar registros a la tabla cliente*****/

INSERT INTO "Cliente" (  "Nombre","Apellido","Sexo","Tipo_Documento","Num_Documento","Direccion","Telefono","Email")
VALUES ('Jhon', 'Rojas','M','Cedula Ciudadania',1233445,'Carrera 109 #-2',6576544,'Jhon@uninpahu.edu.co');

/**** para mostrar la tabla cliente****/
 select * from Cliente



/*****procedmiento de traer listado de los registros en  tabla cliente *****/ 
 
CREATE PROCEDURE [dbo].[ListarClientes]
AS
SELECT Idcliente [Id],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Apellido,'')[Apellido],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Sexo,'')[Sexo],
    ISNULL(Tipo_Documento,'')[Tipo_documento],
    ISNULL(Num_Documento,'')[Num_documento],
    ISNULL(Direccion,'')[Direccion],
    ISNULL(Telefono,'')[Telefono],
    ISNULL(Email,'')[Email]
FROM Cliente
Go
/*****procedmiento de traer listado por id de los registros en  tabla cliente *****/ 
CREATE PROCEDURE TraerClientePorId
@ID int
AS
SELECT Idcliente [Id],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Apellido,'')[Apellido],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Sexo,'')[Sexo],
    ISNULL(Tipo_Documento,'')[Tipo_documento],
    ISNULL(Num_Documento,'')[Num_documento],
    ISNULL(Direccion,'')[Direccion],
    ISNULL(Telefono,'')[Telefono],
    ISNULL(Email,'')[Email]
FROM Cliente
WHERE Idcliente = @ID
GO
 /*****procedmiento de insertar en tabla cliente*****/ 
CREATE PROCEDURE InsertarCliente
    
    
	@Nombre varchar(20) ,
	@Apellido varchar(40),
	@Sexo varchar(1),
	@Tipo_Documento varchar(20),
    @Num_Documento varchar(10),
    @Direccion varchar(20),
    @Telefono varchar(20),
    @Email varchar(20)
AS
INSERT INTO Cliente(Nombre,Apellido,Sexo,Tipo_Documento,Num_Documento,Direccion,Telefono,Email)
VALUES(@Nombre,@Apellido,@Sexo,@Tipo_Documento,@Num_Documento,@Direccion,@Telefono,@Email)
GO
 /*****procedmiento de actualizar en tabla cliente*****/ 
CREATE PROCEDURE ActualizarCliente
    
    @Idcliente int ,
	@Nombre varchar(20) ,
	@Apellido varchar(40),
	@Sexo varchar(1),
	@Tipo_Documento varchar(20),
    @Num_Documento varchar(10),
    @Direccion varchar(20),
    @Telefono varchar(20),
    @Email varchar(20)
    AS
UPDATE Cliente SET Nombre = @Nombre,
    Apellido = @Apellido, Sexo = @Sexo, Tipo_Documento =@Tipo_Documento,Num_Documento=@Num_Documento, Direccion =@Direccion,
    Telefono = @Telefono,Email =@Email
WHERE Idcliente = @Idcliente
GO
 /*****procedmiento de eliminar en  tabla cliente*****/
CREATE PROCEDURE EliminarCliente
    @ID INT
AS
DELETE FROM Cliente
WHERE Idcliente = @ID



/****************CREAR tabla vendedor****************************************/
CREATE TABLE Vendedor(
	Idvendedor int IDENTITY(1,1) NOT NULL,
	Nombre varchar(20) NOT NULL,
	Apellido varchar(40)NULL,
	Sexo varchar(1) NULL,
	Tipo_Documento varchar(20)NOT NULL,
    Num_Documento varchar(10)NOT NULL,
    Direccion varchar(20)NULL,
    Telefono varchar(20)NULL,
    Email varchar(20)NULL, 
	Acceso varchar(20) NOT NULL,
	Usuario varchar(20) NOT NULL,
	Password varchar(20) NOT NULL,
 CONSTRAINT [PK_Vendedor] PRIMARY KEY CLUSTERED 
(
	[idvendedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

/****** insertar registros a la tabla VENDEDOR*****/

INSERT INTO "Vendedor" (  "Nombre","Apellido","Sexo","Tipo_Documento","Num_Documento","Direccion","Telefono","Email",Acceso,Usuario,Password)
VALUES ('Jhon', 'Rojas','M','Cedula Ciudadania',1233445,'Carrera 109 #-2',6576544,'Jhon@uninpahu.edu.co','administrador','jrojas',12345);

/**** para mostrar la tabla VENDEDOR****/
 select * from Vendedor
 
 /*****procedmiento de traer listado de los registros en  tabla VENDEDOR *****/ 
 
CREATE PROCEDURE [dbo].[ListarVendedor]
AS
SELECT Idvendedor [Id],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Apellido,'')[Apellido],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Sexo,'')[Sexo],
    ISNULL(Tipo_Documento,'')[Tipo_documento],
    ISNULL(Num_Documento,'')[Num_documento],
    ISNULL(Direccion,'')[Direccion],
    ISNULL(Telefono,'')[Telefono],
    ISNULL(Email,'')[Email],
    ISNULL(Acceso,'')[Acceso],
    ISNULL(Usuario,'')[Usuario],
    ISNULL(Password,'')[Password]
FROM Vendedor
Go
/*****procedmiento de traer listado por id de los registros en  tabla VENDEDOR *****/ 
CREATE PROCEDURE TraerVendedorPorId
@ID int
AS
SELECT Idvendedor [Id],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Apellido,'')[Apellido],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Sexo,'')[Sexo],
    ISNULL(Tipo_Documento,'')[Tipo_documento],
    ISNULL(Num_Documento,'')[Num_documento],
    ISNULL(Direccion,'')[Direccion],
    ISNULL(Telefono,'')[Telefono],
    ISNULL(Email,'')[Email],
    ISNULL(Acceso,'')[Acceso],
    ISNULL(Usuario,'')[Usuario],
    ISNULL(Password,'')[Password]
FROM Vendedor
WHERE Idvendedor = @ID
GO
 /*****procedmiento de insertar en tabla VENDEDOR*****/ 
CREATE PROCEDURE InsertarVendedor
    
    
	@Nombre varchar(20) ,
	@Apellido varchar(40),
	@Sexo varchar(1),
	@Tipo_Documento varchar(20),
    @Num_Documento varchar(10),
    @Direccion varchar(20),
    @Telefono varchar(20),
    @Email varchar(20),
    @Acceso varchar(20),
	@Usuario varchar(20),
	@Password varchar(20)
AS
INSERT INTO Vendedor(Nombre,Apellido,Sexo,Tipo_Documento,Num_Documento,Direccion,Telefono,Email,Acceso,Usuario,Password)
VALUES(@Nombre,@Apellido,@Sexo,@Tipo_Documento,@Num_Documento,@Direccion,@Telefono,@Email,@Acceso, @Usuario,@Password)
GO
 /*****procedmiento de actualizar en tabla VENDEDOR*****/ 
CREATE PROCEDURE ActualizarVendedor
    
    @Idvendedor int ,
	@Nombre varchar(20) ,
	@Apellido varchar(40),
	@Sexo varchar(1),
	@Tipo_Documento varchar(20),
    @Num_Documento varchar(10),
    @Direccion varchar(20),
    @Telefono varchar(20),
    @Email varchar(20),
    @Acceso varchar(20),
	@Usuario varchar(20),
	@Password varchar(20)
    AS
UPDATE Vendedor SET Nombre = @Nombre,
    Apellido = @Apellido, Sexo = @Sexo, Tipo_Documento =@Tipo_Documento,Num_Documento=@Num_Documento, Direccion =@Direccion,
    Telefono = @Telefono,Email =@Email, Acceso=@Acceso, Usuario=@Usuario,Password =@Password
WHERE Idvendedor = @Idvendedor
GO
 /*****procedmiento de eliminar en  tabla VENDEDOR*****/
CREATE PROCEDURE EliminarVendedor
    @ID INT
AS
DELETE FROM Vendedor
WHERE Idvendedor = @ID
GO

/*****procedmiento de ingreso del vendedor o adminstrador*****/
create proc splogin
@usuario varchar(20),
@password varchar(20)
as
select Idvendedor,Apellido,Nombre,Acceso
from Vendedor
where Usuario=@usuario and Password=@password

GO
/**************crear tabla del articulo***********/
CREATE TABLE Articulo(
	Idarticulo int IDENTITY(1,1) NOT NULL,
	Codigo varchar(50)NOT NULL,
	Nombre varchar(50) NOT NULL,
	Descripcion varchar(40)NULL,
	IdCategoria int NOT NULL,
	Precio_compra bigint NOT NULL,
	Precio_venta bigint NOT NULL,
	Stock_inicial bigint NOT NULL,
	Stock_actual  bigint NOT NULL,
	Fecha_produccion varchar(50) NOT NULL,
	Fecha_vencimiento varchar(50) NOT NULL,
	
   
 CONSTRAINT [PK_Articulo] PRIMARY KEY CLUSTERED 
(
	Idarticulo ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
/********** colocar llave foranea del arcticulo categoria*********/
ALTER TABLE [dbo].[articulo]  WITH CHECK ADD  CONSTRAINT [FK_articulo_categoria] FOREIGN KEY([idcategoria])
REFERENCES [dbo].[categoria] ([idcategoria])

ALTER TABLE [dbo].[articulo] CHECK CONSTRAINT [FK_articulo_categoria]

/******mostrar la tabla del articulo*******************/
select * from Articulo
/*****procedmiento de traer listado de los registros en  tabla Articulo *****/ 
 
CREATE PROCEDURE [dbo].[ListarArticulo]
AS
SELECT Idarticulo [ID],
	ISNULL(Codigo,'')[Codigo],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Descripcion,'')[Descripcion],
    ISNULL(IdCategoria,'')[IdCategoria],
    ISNULL(Precio_compra,'')[Precio_compra],
    ISNULL(Precio_venta,'')[Precio_venta],
    ISNULL(Stock_inicial,'')[Stock_inicial],
    ISNULL(Stock_actual,'')[Stock_actual],
    ISNULL(Fecha_produccion,'')[Fecha_produccion],
    ISNULL(Fecha_vencimiento,'')[Fecha_vencimiento]
    
FROM Articulo
Go
/*****procedmiento de traer listado por id de los registros en  tabla Articulo *****/ 
CREATE PROCEDURE TraerArticuloPorId
@ID int
AS
SELECT Idarticulo [ID],
	ISNULL(Codigo,'')[Codigo],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Descripcion,'')[Descripcion],
    ISNULL(IdCategoria,'')[IdCategoria],
    ISNULL(Precio_compra,'')[Precio_compra],
    ISNULL(Precio_venta,'')[Precio_venta],
    ISNULL(Stock_inicial,'')[Stock_inicial],
    ISNULL(Stock_actual,'')[Stock_actual],
    ISNULL(Fecha_produccion,'')[Fecha_produccion],
    ISNULL(Fecha_vencimiento,'')[Fecha_vencimiento]
    
FROM Articulo
WHERE Idarticulo = @ID
GO
 /*****procedmiento de insertar en tabla Articulo*****/ 
CREATE PROCEDURE InsertarArticulo
   
	@Codigo varchar(50),
	@Nombre varchar(50),
	@Descripcion varchar(40),
	@IdCategoria int ,
	@Precio_compra bigint ,
	@Precio_venta bigint ,
	@Stock_inicial bigint ,
	@Stock_actual  bigint ,
	@Fecha_produccion varchar(50) ,
	@Fecha_vencimiento varchar(50)
AS
INSERT INTO Articulo(Codigo,Nombre,Descripcion,IdCategoria,Precio_compra,Precio_venta,Stock_inicial,Stock_actual,Fecha_produccion,Fecha_vencimiento)
VALUES(@Codigo,@Nombre,@Descripcion,@IdCategoria,@Precio_compra,@Precio_venta,@Stock_inicial,@Stock_actual,@Fecha_produccion,@Fecha_vencimiento)
GO
 /*****procedmiento de actualizar en tabla Articulo*****/ 
CREATE PROCEDURE ActualizarArticulo
    
    @IdArticulo int ,
    @Codigo varchar(50),
	@Nombre varchar(50),
	@Descripcion varchar(40),
	@IdCategoria int ,
	@Precio_compra bigint ,
	@Precio_venta bigint ,
	@Stock_inicial bigint ,
	@Stock_actual  bigint ,
	@Fecha_produccion varchar(50) ,
	@Fecha_vencimiento varchar(50)
    
    AS
UPDATE Articulo SET Codigo = @Codigo,
    Nombre = @Nombre, Descripcion = @Descripcion, IdCategoria =@IdCategoria, Precio_compra=@Precio_compra, Precio_venta =@Precio_venta,
    Stock_inicial = @Stock_inicial,Stock_actual =@Stock_actual, Fecha_produccion=@Fecha_produccion, Fecha_vencimiento=@Fecha_vencimiento
WHERE Idarticulo = @IdArticulo
GO
 /*****procedmiento de eliminar en  tabla Articulo*****/
CREATE PROCEDURE EliminarArticulo
    @ID INT
AS
DELETE FROM Articulo
WHERE Idarticulo = @ID
GO
/**************crear tabla del Pedido***********/
CREATE TABLE Pedido(
	IdPedido int IDENTITY(1,1) NOT NULL,
	IdCliente int NOT NULL,
	IdVendedor int NOT NULL,
	Total_pedido decimal NOT NULL,
	Fecha_pedido varchar(50) NOT NULL,
	Aceptacion_pedido varchar (50) NOT NULL
	
	
	
   
 CONSTRAINT [PK_Pedido] PRIMARY KEY CLUSTERED 
(
	IdPedido ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
/********** colocar llave foranea del del pedido (cliente, vendedor, articulo)*********/
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

/******mostrar la tabla del Pedido*******************/
select * from Pedido
/*****procedmiento de traer listado de los registros en  tabla Pedido *****/ 
 
CREATE PROCEDURE [dbo].[ListarPedido]
AS
SELECT IdPedido [ID],
	ISNULL(IdCliente,'')[IdCliente],
    ISNULL(IdVendedor,'')[IdVendedor],
    ISNULL(Total_pedido,'')[Total_pedido],
    ISNULL(Fecha_pedido,'')[Fecha_pedido],
    ISNULL(Aceptacion_pedido,'')[Aceptacion_pedido]
    
    
FROM Pedido
Go
/*****procedmiento de traer listado por id de los registros en  tabla Pedido *****/ 
CREATE PROCEDURE TraerPedidoPorId
@ID int
AS
SELECT  IdPedido [ID],
	ISNULL(IdCliente,'')[IdCliente],
    ISNULL(IdVendedor,'')[IdVendedor],
    ISNULL(Total_pedido,'')[Total_pedido],
    ISNULL(Fecha_pedido,'')[Fecha_pedido],
    ISNULL(Aceptacion_pedido,'')[Aceptacion_pedido]
    
FROM Pedido
WHERE IdPedido = @ID
GO
 /*****procedmiento de insertar en tabla Pedido*****/ 
CREATE PROCEDURE InsertarPedido
   
	
	@IdCliente int ,
	@IdVendedor int ,
	@Total_pedido decimal ,
	@Fecha_pedido varchar(50) ,
	@Aceptacion_pedido varchar(50) 
	
	
AS
INSERT INTO Pedido(IdCliente,IdVendedor,Total_pedido,Fecha_pedido,Aceptacion_pedido)
VALUES (@IdCliente,@IdVendedor,@Total_pedido,@Fecha_pedido,@Aceptacion_pedido)
GO
 /*****procedmiento de actualizar en tabla Pedido*****/ 
CREATE PROCEDURE ActualizarPedido
    
    @IdPedido int ,
    @IdCliente int ,
	@IdVendedor int ,
	@Total_pedido int ,
	@Fecha_pedido varchar(50) ,
	@Aceptacion_pedido varchar(50)
    AS
UPDATE Pedido SET IdCliente = @IdCliente,
    IdVendedor = @IdVendedor, Total_pedido = @Total_pedido, Fecha_pedido =@Fecha_pedido, Aceptacion_pedido=@Aceptacion_pedido
WHERE IdPedido = @IdPedido
GO
 /*****procedmiento de eliminar en  tabla Pedido*****/
CREATE PROCEDURE EliminarPedido
    @ID INT
AS
DELETE FROM Pedido
WHERE IdPedido = @ID
GO
/**************crear tabla del Detalle_Pedido***********/
CREATE TABLE Detalle_pedido(
	IdDetalle int IDENTITY(1,1) NOT NULL,
	IdPedido int NOT NULL,
	IdArticulo int NOT NULL,
	Precio_unitario decimal (18,2) NOT NULL,
	Valor_total decimal (18,2) NOT NULL,
	Cantidad int NOT NULL
	
 CONSTRAINT [PK_Detalle_pedido] PRIMARY KEY CLUSTERED 
(
	IdDetalle ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
/********** colocar llave foranea del Detalle_Pedido (pedido, articulo)*********/
ALTER TABLE [dbo].[Detalle_pedido]  WITH CHECK ADD  CONSTRAINT [FK_Detalle_pedido_pedido] FOREIGN KEY([idPedido])
REFERENCES [dbo].[Pedido] ([idpedido])
GO
ALTER TABLE [dbo].[Detalle_pedido] CHECK CONSTRAINT [FK_Detalle_pedido_pedido]
GO

ALTER TABLE [dbo].[Detalle_pedido]  WITH CHECK ADD  CONSTRAINT [FK_Detalle_pedido_articulo] FOREIGN KEY([idArticulo])
REFERENCES [dbo].[Articulo] ([idarticulo])
GO
ALTER TABLE [dbo].[Detalle_pedido] CHECK CONSTRAINT [FK_Detalle_pedido_Articulo]
GO

/******mostrar la tabla del Detalle_Pedido*******************/
select * from Detalle_pedido
/*****procedmiento de traer listado de los registros en  tabla Detalle_Pedido *****/ 
 
CREATE PROCEDURE[dbo].[ListarDetalle_pedido]
AS
SELECT IdDetalle [ID],
	ISNULL(IdPedido,'')[IdPedido],
   ISNULL(a.Idarticulo,'')[IdArticulo],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Precio_unitario,'')[Precio_unitario],
    ISNULL(Valor_total,'')[Valor_total],
    ISNULL(Cantidad,'')[Cantidad]
    
   
    
FROM Detalle_pedido d inner join Articulo a
on d.IdArticulo=a.Idarticulo
--exec [ListarDetalle_pedido] 
Go
/*****procedmiento de traer listado por id de los registros en  tabla Detalle_Pedido*****/ 
CREATE PROCEDURE TraerDetall_pedidoPorId
@ID int
AS
SELECT IdDetalle [ID],
	ISNULL(IdPedido,'')[IdPedido],
    ISNULL(a.Idarticulo,'')[IdArticulo],
    ISNULL(a.Nombre,'')[Nombre],
    ISNULL(Precio_unitario,'')[Precio_unitario],
    ISNULL(Valor_total,'')[Valor_total],
    ISNULL(Cantidad,'')[Cantidad]
    
FROM Detalle_pedido d inner join Articulo a
on d.IdArticulo=a.Idarticulo
WHERE IdDetalle = @ID
GO
--exec TraerDetalle_pedidoPorId del pedido
CREATE PROCEDURE [dbo].[TraerDetalle_pedidoPorId]
@ID int
AS
SELECT IdDetalle [ID],
	ISNULL(IdPedido,'')[IdPedido],
    ISNULL(a.Idarticulo,'')[IdArticulo],
    ISNULL(a.Nombre,'')[Nombre],
    ISNULL(Precio_unitario,'')[Precio_unitario],
    ISNULL(Valor_total,'')[Valor_total],
    ISNULL(Cantidad,'')[Cantidad]
    
FROM Detalle_pedido d inner join Articulo a
on d.IdArticulo=a.Idarticulo
WHERE IdPedido = @ID
--exec TraerDetalle_pedidoPorId 4
 /*****procedmiento de insertar en tabla Detalle_Pedido*****/ 
CREATE PROCEDURE [dbo].[InsertarDetalle_pedido]

	
	@IdPedido int,
	@IdArticulo int ,
	@Precio_unitario decimal (18,2),
	@Valor_total decimal (18,2),
	@Cantidad int 
	
	
AS
INSERT INTO Detalle_pedido(IdPedido,IdArticulo,Precio_unitario,Valor_total,Cantidad)
VALUES (@IdPedido,@IdArticulo,@Precio_unitario,@Valor_total,@Cantidad)


--exec [InsertarDetalle_pedido] 2,3,100,200,2
GO
 /*****procedmiento de actualizar en tabla Detalle_Pedido*****/ 
CREATE PROCEDURE ActualizarDetalle_pedido
    
   @IdDetalle int,
	@IdPedido int,
	@IdArticulo int ,
	@Nombre varchar, 
	@Precio_unitario decimal (18,2),
	@Valor_total decimal (18,2),
	@Cantidad int 
    AS
UPDATE Detalle_pedido SET IdPedido = @IdPedido,
    IdArticulo = @IdArticulo, Precio_unitario = @Precio_unitario, Valor_total =@Valor_total, Cantidad=@Cantidad
WHERE IdDetalle = @IdDetalle
GO
 /*****procedmiento de eliminar en  tabla Detalle_Pedido*****/
CREATE PROCEDURE EliminarDetalle_pedido
    @ID INT
AS
DELETE FROM Detalle_pedido
WHERE IdDetalle = @ID
GO
