<?php
function puntouno(){
		echo "EJEJRCICIO 01"."<br>";
		$SUMAR=0;
		for($i=1;$i<=100;$i++)
					{
							if($i%3==0)
							{
								echo $i."  ES MULTIPLO DE 3". "<br>";
								$SUMAR=$SUMAR + $i;
							}
							
					}
		echo "La suma de los numeros multiplos de 3 es :".$SUMAR;			
	}

//punto 2
function puntodos(){
		echo "EJEJRCICIO 02"."<br>";
		$DIASTOTALES=1423;
		$MESES=0;
		$ANOS=0;
		$CONTADOR=0;
		$CONTADOR1=0;
		echo "LOS ".$DIASTOTALES." DIASTOTALES <br>";
		while($CONTADOR <= $DIASTOTALES) {
			if ($CONTADOR1 == 30){
				$MESES=$MESES + 1;
				$CONTADOR1 = 0;
			}
			elseif ($MESES == 12) {
				 $ANOS=$ANOS + 1;
				 $MESES = 0;
			}
			$CONTADOR++;
			$CONTADOR1++;
		}
		$CONTADOR1=$CONTADOR1-1;
		ECHO "SON ".$ANOS." AÑOS ".$MESES." MESES ".$CONTADOR1." DIAS";	
			
	}
//punto 3
function puntotres(){
		echo "EJEJRCICIO 03"."<br>";
		$NOTA = 8;
		$A = array(19, 20);
		$B = array(16, 17, 18);
		$C = array(13, 14, 15);
		$D = array(10, 11, 12);
		$E = array(1, 2, 3, 4, 5, 6, 7, 8, 9);
		echo "nota definitiva = ".$NOTA."<br>";
		for ($i = 0; $i < count($A); $i++) {
			if ($NOTA == $A[$i]){
				ECHO "NOTAFINAL = A";
				BREAK;
			}
		} 

		for ($i = 0; $i < count($B); $i++) {
			if ($NOTA == $B[$i]){
				ECHO "NOTAFINAL = B";
			}
		} 

		for ($i = 0; $i < count($C); $i++) {
			if ($NOTA == $C[$i]){
				ECHO "NOTAFINAL = C";
			}
		} 

		for ($i = 0; $i < count($D); $i++) {
			if ($NOTA == $D[$i]){
				ECHO "NOTAFINAL = D";
			}
		} 

		for ($i = 0; $i < count($E); $i++) {
			if ($NOTA == $E[$i]){
				ECHO "NOTAFINAL = E";
			}
		} 

	}
//punto 4
function puntocuatro(){
		echo "EJEJRCICIO 04"."<br>";
		$MONTO = 30;
		echo "TOTAL EL MONTO DE COMPRA ES ".$MONTO."<br>";
		switch ($MONTO) {
			case ($MONTO >= 100):
				ECHO "VALOR DE LA COMPRA ES; ".$MONTO."<BR>";
				ECHO "DESCUENTO 10% "."Valor a Pagar con descuento de: ".($MONTO - ($MONTO * 0.10));
				break;
			case ($MONTO >= 300):
				ECHO "VALOR DE LA COMPRA ES; ".$MONTO."<BR>";
				ECHO "DESCUENTO 20% "."Valor a Pagar con descuento de: ".($MONTO - ($MONTO * 0.20));
				break;
			case ($MONTO < 100):
				ECHO "NO HAY DESCUENTO";
				break;
			default:
				
		}

	}

//punto 5
/*<!DOCTYPE html>

<html>

<head>

<title>Tres Variables</title>

<meta charset="utf-8">

</head>

<body>

<form name="formularioDatos" method="post" action="ejemploPost1.php">

<p> TRES VALORES </p>

<br/>



Introduzca el primer valor: <input type="text" name="primer" value="">

<br/> <br/>

Introduzca el segundo valor: <input type="text" name="segundo" value="">

<br/> <br/>

Introduzca el tercer valor: <input type="text" name="tercero" value="">

<br/> <br/>

<script> 
function comprobarREPETIR(){ 
   	DATO1 =  primer.value 
   	//DATO2 = name.segundo.value
	//DATO3 = name.tercero.value
	alert(DATO1)
   	//if (DATO1 == DATO2) 
      	//alert("LOs dos VALORES son iguales...\nRealizaríamos las acciones del caso positivo") 
   	//if  (DATO2 == DATO3)
      	//alert("LOs dos VALORES son iguales...\nRealizaríamos las acciones del caso negativo")
	//if (DATO1 == DATO3)	
		//alert("LOs dos VALORES son iguales...\nRealizaríamos las acciones del caso negativo")
} 
</script> 

<input type="button" value="Comprobar si son iguales" onClick="comprobarREPETIR()">

<input value="Calcular" type="submit" />

</form>

</body>

</html>*/

//Ejercicio 6
function puntoseis(){
		echo "EJEJRCICIO 06"."<br>";
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
	}
/* Punto 7 */

 function puntosiete(){
		echo "EJEJRCICIO 07"."<br>";
		$datos = 50;
		$Mcinco=" ";
		$arreglo = NULL;   // el array donde se almacena los números

		echo "Los n&uacute;meros del array son:<br />";
		for ($i = 0; $i < $datos; $i++ ) {
		$arreglo[$i] = mt_rand(1,100);
		echo $arreglo[$i]. ", ";
		if ( ($arreglo[$i] % 5) == 0) {
		$Mcinco = $Mcinco.$arreglo[$i]. ", ";
		}
		}
		echo "<pre>";
		echo "Los n&uacute;meros multiplos de cinco son:<br />";
		echo $Mcinco;
		echo "<pre/>";
	}
/* Punto 8 */
 function puntoocho(){
		echo "EJEJRCICIO 08"."<br>";
		$Earrego=array(1, 2, 22, 4, 5, 6, 15, 35, 27);
		echo "<pre>";
		var_export ($Earrego);
		echo "<pre/>"; 
		unset($Earrego[2]);
		echo "<pre>";
		var_export ($Earrego);
		echo "<pre>";
	}
 //EJERCICIO 09
 function puntonueve(){
		echo "EJEJRCICIO 09"."<br>";
		$original = array( "Albert","David","Pinilla","Torres","Roberto","Mauricio","Cardona","Pacheco","Emili","Anabelle");
		echo "El array original es: "."<br>";
		for ($i=0;$i<5;$i++){     
		echo $original[$i]." ";
		 }    
		 echo "<pre>";
		echo "El array modificado es: "."<br>";
		array_splice( $original, 4, 0, "Paula" );
		for ($i=0;$i<5;$i++){     
		echo $original[$i]," ";
		 } 
		echo "<br><br><br>";
	}
//EJERCICIO 10
function puntodiez(){
		echo "EJEJRCICIO 10"."<br>";
		$eje10=array(1,2,3,4,5,6,7,8,9,10,11,12,13,20,30,10,25,34,15,21);
		echo "El primer array es: "."<br>";
		for ($i=0;$i<20;$i++){
		  echo $eje10[$i]." ";  
		 }
		echo ("<br>");
		echo "Los numeros del array multiplos de 3: "."<br>";
		for ($i=0;$i<20;$i++){
		 if ( $eje10[$i] % 3 == 0) {  
		  echo $eje10[$i]." "; 
			}  
		}
		echo "<br><br><br>";
	}
//Ejercicio 11
 function puntoonce(){
			echo "EJEJRCICIO 11"."<br>";
			$nros_a_generar = 20;
			$suma=20;
			$sumaimp=0;
			$numeros = NULL;   // el array donde se almacena los números

			echo "Los n&uacute;meros del array...<br />";
			for ($i = 0; $i < $nros_a_generar; $i++ ) {
			$numeros[$i] = mt_rand(1,20);
			echo $numeros[$i]. " ";
			}
			echo "<br/>";
			echo "Los n&uacute;meros del nuevo  array con pares son: ...<br />";
			for ($i=0; $i < $nros_a_generar; $i++) {
			if ( ($numeros[$i] % 2) == 0) {  // es par
			$suma=$numeros[$i];
			echo "<br />";
			echo $suma;
				}
			}
	}

//Ejercicio 13
 
function puntotrece(){
		echo "EJEJRCICIO 13"."<br>";
		$nros_a_generar = 8;
		$suma=null;
		$sumaimp=null;
		$numeros = NULL;   // el array donde se almacena los números

		echo "Los n&uacute;meros del array...<br />";
		for ($i = 0; $i < $nros_a_generar; $i++ ) {
		$numeros[$i] = mt_rand(1,20);
		echo $numeros[$i]. " ";
		}
		echo "<br/>";
		echo "Los n&uacute;meros del nuevo  array del ultimo hasta el primero son: ...<br />";
		for ($i=7; $i >$sumaimp; $i--) {
		$suma=$numeros[$i];
		echo "<br />";
		echo $suma;
		 
		}
	}



// Ejercicio 15
function puntoquince(){
		echo "EJEJRCICIO 15"."<br>";
		$valores=array(2,18,11,2,41,91,15,2,14,2);
		$suma=0;
		$sumaimp=2;// la variable a comparar
		$numeros = NULL;   // el array donde se almacena los números del nuevo arreglo
		echo "<pre>";
		print_r( "El valor de la variable es : ".$sumaimp); 
		echo "<pre/>";
		echo "Los n&uacute;meros del arreglo:.<br />";


		for ($i=0;$i<10;$i++){
		if ( $valores[$i]  == $sumaimp) {  // si el dato del array es igual al de la constante
		$suma = $suma+1;
		}
		echo $valores[$i]."   ";
		}

		echo "<pre>";
		print_r( "Se repite la variable en el arreglo: ".$suma); 
		echo "<pre/>";

		 
		echo "<pre>";
		echo "Los n&uacute;meros del nuevo arreglo...<br />";
		 
		for ($i = 0; $i < $suma; $i++ ) {
		$numeros[$i] = mt_rand(1,20);
		echo $numeros[$i]. "  ";
		}
	}
 
//Ejercicio 16
function puntodieciseis(){ 
		echo "EJEJRCICIO 16"."<br>";
		$nros_a_generar = 20;
		$suma=0;
		$sumaimp=6;// la variable a comparar
		$numeros = NULL;   // el array donde se almacena los números
		 echo "<pre>";
		print_r( "El valor de la variable es = ".$sumaimp); 
		echo "<pre/>";
		echo "Los n&uacute;meros del array...<br />";
					   for ($i = 0; $i < $nros_a_generar; $i++ ) {
					   $numeros[$i] = mt_rand(1,20);
					   echo $numeros[$i]. " ";
					   }
		 
					   for ($i=0; $i < $nros_a_generar; $i++) {
					   if ( $numeros[$i]  == $sumaimp) {  // si el dato del array es igual al de la constante
					   $suma = $suma+1;
					   }
		 
		}
		 
		echo "<pre>";
		print_r( "Se repite la variable en el arreglo: ".$suma);
		 
		echo "<pre/>";
	} 
 
//Ejercicio 17
function puntodiecisiete(){
		echo "EJEJRCICIO 17"."<br>";
		$nros_a_generar = 20;
		$suma=0;
		$sumaimp=0;
		$numeros = NULL;   // el array donde se almacena los números

		echo "Los n&uacute;meros del array...<br />";
		for ($i = 0; $i < $nros_a_generar; $i++ ) {
		$numeros[$i] = mt_rand(1,20);
		echo $numeros[$i]. " ";
		}

		for ($i=0; $i < $nros_a_generar; $i++) {
		if ( ($numeros[$i] % 2) == 0) {  // es par
		$suma = $suma+$numeros[$i];
		}
		else {
		$sumaimp=$sumaimp+$numeros[$i];
		}
		}
		echo "<pre>";
		print_r( "La suma de los numeros pares es: ".$suma); 
		echo "<pre/>";
		echo "<pre>";
		echo "La suma de los numeros impares es: ".$sumaimp; 
		echo "<pre/>";
	}

//Ejercicio 18
 function dieciocho(){
		echo "EJEJRCICIO 18"."<br>";
		$valores=array(15,18,13,20,45,96,35,12,47,25);
		$suma=0;
		echo"<pre>";
		print_r($valores);
		echo"</pre>";

		for ($i=0;$i<10;$i++){
		$suma=$suma+$valores[$i];
		 
		}
		echo"<pre>";
		print_r("El Total de la suma del array es: ".$suma);
		echo"</pre>";
	}

//Ejercicio 19
 function diecinueve(){
		echo "EJEJRCICIO 19"."<br>";
		$numeros=array(10,9,8,7,6,5,4,3,2,1);

		echo"<pre>";
		print_r($numeros);
		echo"</pre>";


		sort($numeros, SORT_REGULAR);


		echo"<pre>";
		print_r($numeros);
		echo"</pre>";
	}
echo"<pre>";	
puntouno();
echo"</pre>";
echo"<pre>";
puntodos();
echo"</pre>";
echo"<pre>";
puntotres();
echo"</pre>";
echo"<pre>";
puntocuatro();
echo"</pre>";


echo"<pre>";
puntoseis();
echo"</pre>";
echo"<pre>";	
puntosiete();
echo"</pre>";
puntoocho();
echo"</pre>";
puntonueve();
echo"</pre>";
puntodiez();
echo"</pre>";	
puntoonce();
echo"</pre>";
puntotrece();
echo"</pre>";
puntoquince();
echo"</pre>";
puntodieciseis();
echo"</pre>";
puntodiecisiete();
echo"</pre>";
dieciocho();
echo"</pre>";
diecinueve();


?>
