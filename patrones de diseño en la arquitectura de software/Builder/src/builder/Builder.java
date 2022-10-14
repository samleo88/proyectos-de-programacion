/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

/**
 *
 * @author ESTUDIANTES
 */
public class Builder {

    public static void main(String[] args)
    {
        // Crear el objeto Director
         Director objFabrica = new Director();
        // Crear los objetos ConcreteBuilder
         BuilderCoche base  = new ConstructorCocheBase();
         BuilderCoche medio = new ConstructorCocheMedio();
         BuilderCoche full  = new ConstructorCocheFull();
        // Construir un coche con equipamiento base
         objFabrica.construir( base );
         Coche cocheBase = base.getCoche();
        // Construir un coche con equipamiento medio
        objFabrica.construir( medio );
        Coche cocheMedio = medio.getCoche();
        // Construir un coche con equipamiento full
        objFabrica.construir( full );
        Coche cocheFull = full.getCoche();
        // Mostrar la información de cada coche creado
        mostrarCaracteristicas( cocheBase );
        mostrarCaracteristicas( cocheMedio );
        mostrarCaracteristicas( cocheFull );
    }
    // --------------------------------
    public static void mostrarCaracteristicas( Coche coche )
    {
        System.out.println( "Motor: " + coche.getMotor() );
        System.out.println( "Carrocería: " + coche.getCarroceria() );
        System.out.println( "Elevalunas eléctrico: " + coche.getElevalunasElec() );
        System.out.println( "Airea acondicionado: " + coche.getAireAcond() );
        System.out.println("===================================");
    }
    
}
