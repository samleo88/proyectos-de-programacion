CREATE DATABASE [Prueba]


USE [Prueba]
GO

/********* crear tabla cliente****/

CREATE TABLE Cliente(
	Idcliente int IDENTITY(1,1) NOT NULL,
	Nombre varchar(20) NOT NULL,
	Apellido varchar(40)NULL,
    Direccion varchar(20)NULL,
 CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
(
	Idcliente ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
/****** insertar registros a la tabla cliente*****/

INSERT INTO "Cliente" (  "Nombre","Apellido","Direccion")
VALUES ('Jhon', 'Rojas','Carrera 109 #-2');

/**** para mostrar la tabla cliente****/
 select * from Cliente



/*****procedmiento de traer listado de los registros en  tabla cliente *****/ 
 
CREATE PROCEDURE [dbo].[ListarClientes]
AS
SELECT Idcliente [Id],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Apellido,'')[Apellido],
    ISNULL(Nombre,'')[Nombre],
    ISNULL(Direccion,'')[Direccion]
    
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
    ISNULL(Direccion,'')[Direccion]

FROM Cliente
WHERE Idcliente = @ID
GO

 /*****procedmiento de insertar en tabla cliente*****/ 

CREATE PROCEDURE InsertarCliente
    
    
	@Nombre varchar(20) ,
	@Apellido varchar(40),
    @Direccion varchar(20)
    
AS
INSERT INTO Cliente(Nombre,Apellido,Direccion)
VALUES(@Nombre,@Apellido,@Direccion)
GO
 /*****procedmiento de actualizar en tabla cliente*****/ 
CREATE PROCEDURE ActualizarCliente
    
    @Idcliente int ,
	@Nombre varchar(20) ,
	@Apellido varchar(40),
    @Direccion varchar(20)
 
    AS
UPDATE Cliente SET Nombre = @Nombre,
    Apellido = @Apellido,  Direccion =@Direccion
    
WHERE Idcliente = @Idcliente
GO
 /*****procedmiento de eliminar en  tabla cliente*****/
CREATE PROCEDURE EliminarCliente
    @ID INT
AS
DELETE FROM Cliente
WHERE Idcliente = @ID
GO
