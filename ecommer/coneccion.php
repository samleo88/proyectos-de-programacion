<?php
//mysqli_connect("servidor","usuario", "contraseña", "base de datos");
$conectar=mysqli_connect("localhost","root", "", "base1");
//operacion crud
$insertar="insert into empleado(nombre,apellido,cedula,edad)values('juan','sanchez',0,23)"; //estructura para ingresar
mysqli_query($conectar,$insertar); //estruc para ingresar datos en mysql
$borrar="delete from empleado where cedula=0";
mysqli_query($conectar,$borrar);
$actualizar="update empleado set apellido='lopez' where nombre='pedro' and apellido='rosas'";
 mysqli_query($conectar,$actualizar);
	$consultar="select*from empleado";
	$visualizar=mysqli_query($conectar,$consultar);//este es el array para hacer la funcion de foreach
	
	foreach ($visualizar as $fila){
		echo $fila['nombre']." ".$fila['apellido']." ".$fila['cedula']." ".$fila['edad'];
		echo "<br/>";
	}

?>