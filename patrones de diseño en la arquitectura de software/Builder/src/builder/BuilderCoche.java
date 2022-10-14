/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

public abstract class BuilderCoche
{
     protected Coche coche;
    // ------------------------------
    public Coche getCoche() {
        return this.coche;
    }
    // ------------------------------
     public void crearNuevoCoche() {
        this.coche = new Coche();
    }
    // ------------------------------------
    // Métodos que deberán ser construídos por las clases que hereden de ésta
     public abstract void construirMotor();
     public abstract void construirCarroceria();
     public abstract void construirAireAcond();
     public abstract void construirElevalunas();
}