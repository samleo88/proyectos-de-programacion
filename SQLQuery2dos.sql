create database tutorial
use tutorial
go
create table usuarios(
		id_usuario int primary key
		,nombre varchar (50) not null
		, edad int not null

)
/*borrar tablas*/
drop table usuarios2
/*ingresar datos*/
insert into usuarios values (3,'miguel', 23);
insert into usuarios values (1,'antonio', 29);
insert into usuarios values (2,'laura', 23);
insert into usuarios values (4,'miguel', 30);
/*hacer consultas*/
select * from usuarios
select id_usuario from usuarios
select usuarios.id_usuario from usuarios
select nombre, id_usuario from usuarios
/*hacer consultas con where*/
select * from usuarios where nombre='miguel';
select nombre from usuarios where id_usuario=3;
/*operadores relacionales*/

select id_usuario, nombre from usuarios where id_usuario >=2
select id_usuario, nombre from usuarios where nombre<> 'miguel'
/*eliminar registros de la base de datos*/

delete from usuarios where id_usuario=4
truncate table usuarios
drop table usuarios



