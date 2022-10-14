/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

/**
 *
 * @author ESTUDIANTES
 */
public class Guerrero extends Enemigo
{
    public Guerrero() {
        System.out.println("Guerrero creado");
    }
    // ------------------------------
    @Override
    public void atacar() {
        System.out.println("El guerrero ataca");
    }
    // ------------------------------
    @Override
    public void detener() {
        System.out.println("El guerrero se detiene");
    }
    // ------------------------------
    @Override
     public Enemigo clonar()
    {
        /*
         * Creamos una nueva instancia y le asignamos los valores actuales para
         * después devolverlo (es también de tipo 'Prototype' ya que hereda de él)
         */
         Guerrero objGuerrero = new Guerrero();
 
     objGuerrero.setNombre( this.getNombre() );
         objGuerrero.setArma( this.getArma() );
 
         return objGuerrero;
    }
}

