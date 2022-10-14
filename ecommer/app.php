<!DOCTYPE html>

<html lang="es">

<head>

    <meta charset="utf-8">

 

    <style>

	table {border-collapse: collapse;}

	table thead tr {background-color:#C0C0C0;}

	table thead th {padding:5px;border:2px solid #fff;}

 

	table tbody tr {background-color:#f2f5f7;}

	table tbody tr:hover {background-color:#e3e9ec;}

	table tbody td {border:2px solid #fff;padding:5px;text-align:center;}

 

	table tbody td:last-child, table thead th:last-child {border-right:0px;}

    </style>

</head>

<body>

 


<?php
$nros_a_generar = 20;
$suma=0;
$indice=0;
$numeros = NULL;   // el array donde se almacena los números

echo "Los n&uacute;meros del array...<br />";
for ($i = 0; $i < $nros_a_generar; $i++ ) {
$numeros[$i] = mt_rand(1,20);
echo $numeros[$i]. " ";
}
echo "<pre>";
echo "Los n&uacute;meros  pares de la posicion del array son...<br />";
echo "<pre/>";

foreach ( $numeros as $indice => $suma ) 
{  
	if ( ($indice % 2) == 0) {  // es par
	echo $numeros[$indice]. " ";
	}
  } 
?>

 

</body>

</html>