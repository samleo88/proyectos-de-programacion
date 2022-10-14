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
public abstract class Enemigo
{
    private String nombre ="";
    private String arma = "DAGA";
    // ------------------------------
    public String getNombre() {
        return this.nombre;
    }
    // ------------------------------
    public void setNombre( String nombre) {
        this.nombre = nombre;
    }
    // ------------------------------
    public String getArma() {
        return this.arma;
    }
    // ------------------------------
    public void setArma( String arma) {
        this.arma = arma;
    }
    // ------------------------------
    // Métodos que deberán ser construídos por las clases que hereden de ésta
     public abstract Enemigo clonar();
    public abstract void atacar();
    public abstract void detener();
}