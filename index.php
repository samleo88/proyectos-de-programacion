<?php

require("conectar.php");
$conecta = new conexion();

$consulta = $conecta->query("SELECT * 
							FROM usuarios
							");
	
?>


<!DOCTYPE html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css"/>

<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
	
</head>

<body>
<!-- begin first page -->
<section id="page1" data-role="page">
	<header data-role="header"><h1>jQuery Mobile</h1></header>
		<div data-role="content" class="content">
			
			<form method="post" action="captura1.php">
				<div class="ui-field-contain">
			
				<label for="codsus">Codigo Suscriptor:</label>
					<select name="susCod" id="susCod" data-native-menu="false">
						<?php foreach ($consulta as $consul) { ?>
			<option value=" " > <?php echo $consul['id']." - ".$consul['cedula']." - ".$consul['nombre']." - ".$consul['apellido']." - ".$consul['email'] ?> </option>
			<?php } ?>
			</select>
	        </div>
	
		<hr>
		<div class="ui-field-contain">
			<input type="submit" name="submit" value="Enviar" data-inline='true'/>
		</div>
	</form>
			<p>First page!</p>
			<p><a href="#page2">Go to Second Page</a></p>
		</div>
	<footer data-role="footer"><h1>O'Reilly</h1></footer>
</section>
<!-- end first page -->

<!-- Begin second page -->

<section id="page2" data-role="page" >
<div data-role="header" data-theme="b">
	<a href="estructurabasica1.html" class="ui-btn ui-icon-home ui-btn-icon-left">Home</a>
	<a href="estructurabasica2.html" data-role="button" data-icon="delete">Delete</a>

		<h1>Mi Universidad</h1>
	<a href="estructurabasica2.html" data-role="button" data-icon="home">Contacto</a>
</div>
	
		<div class="content" data-role="content">
			<div data-role="content">
				<form action="registro.php" method="post">
				<div data-role="fieldcontain">
						<label for="id">ID:</label>
						<input type="text" name="id" id="id" value="" />
					</div>
					<div data-role="fieldcontain">
						<label for="nombre">Nombre:</label>
						<input type="text" name="nombre" id="nombre" value="" />
					</div>
					<div data-role="fieldcontain">
						<label for="apellido">Apellido:</label>
						<input type="text" name="apellido" id="apellido" value="" />
					</div>
				<div data-role="fieldcontain">
						<label for="email">Email:</label>
						<input type="text" name="email" id="email" value="" />
				</div>
				<div data-role="fieldcontain">
						<label for="cedula">Cedula:</label>
						<input type="text" name="cedula" id="cedula" value="" />
				</div>
				<div data-role="footer" >
				<nav data-role="navbar" data-theme="a" class="ui-bar">
				<ul>
					<li><a href="captura.php" class="ui-btn-active">Igresar</a></li>
					<li><a href="#">Registro</a></li>
				</ul>
				</nav>
				</form>
			</div>
		</div>
	<footer data-role="footer"><center><p><a href="#page3">Facultad de ingenieria</a></p></center></footer>
</section>

<!-- end second page -->	
<section id="page3" data-role="page">
	<div data-role="header" data-theme="b">
	<a href="estructurabasica1.html" class="ui-btn ui-icon-home ui-btn-icon-left">Home</a>
	<a href="estructurabasica2.html" data-role="button" data-icon="delete">Delete</a>
		<h1>Mi Universidad</h1>
	<a href="estructurabasica2.html" data-role="button" data-icon="home">Contacto</a>
</div>
		<nav data-role="navbar" data-theme="a">
			<ul>
			<li><a href="#">Estuadiante</a></li>
			<li><a href="#">Profesor</a></li>
			<li><a href="#">Decano</a></li>
			</ul>
		</nav>
		<h3>Materias</h3>
			<ul data-role="listview">
			<li><a href="#">Calculo</a></li>
			<li><a href="#">Ingles</a></li>
			<li><a href="#">Programacion</a></li>
			</ul>
		<h3>Electivas</h3>
			<ol data-role="listview">
			<li><a href="#">Diciplinar</a></li>
			<li><a href="#">Profesional</a></li>
			<li><a href="#">Complementaria</a></li>
			</ol>
		
		
<nav data-role="navbar" data-theme="a">
			<ul>
			<li><a href="#">Contacto</a></li>
			<li><a href="#">Semestre</a></li>
			<li><a href="#">Comunicados facultad</a></li>
			</ul>
		</nav>
	<div data-role="footer" >
    <nav data-role="navbar" data-theme="a" class="ui-bar">
			<ul>
			<li><a href="#page1" class="ui-btn-active">Inicio</a></li>
			<li><a href="#">Ayuda</a></li>
			</ul>
	</nav>
</div>	
</div>
</section>

<!-- end third page -->

</body>
</html>

