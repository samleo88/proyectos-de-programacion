create database animal
go
use animal
go

create table mascotas
( 
	id int identity (1,1),
	nombreMascota varchar (20),
	descripcionMascota varchar (100),
	raza varchar (20),
	genero varchar (20),
	edad varchar (20),
	fechaRegistro smalldatetime default (getdate())
)
go
 
 create procedure SPmascotas
	@opc int 
	,@id int
	,@nombreMascota varchar 
	,@descripcionMascota varchar 
	,@raza varchar 
	,@genero varchar 
	,@edad varchar 
	,@fechaRegistro smalldatetime
	as
	if @opc =1
	begin
	select * from mascotas
	end
	if @opc =2
	begin
	insert into mascotas(nombreMascota
						,descripcionMascota
						,raza 
						,genero
						,edad )
				values (@nombreMascota
						,@descripcionMascota
						,@raza
						,@genero
						,@edad )
	end
	go