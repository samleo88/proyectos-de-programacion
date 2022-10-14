/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

public class ConstructorCocheFull extends BuilderCoche
{
    public ConstructorCocheFull() {
    }
    // ------------------------------
    @Override
     public void construirMotor() {
        this.coche.setMotor( "Motor de potencia alta" );
    }
    // ------------------------------
    @Override
     public void construirCarroceria() {
        this.coche.setCarroceria( "Carrocería de alta protección" );
    }
    // ------------------------------
    @Override
     public void construirAireAcond() {
        this.coche.setAireAcond( true );
    }
    // ------------------------------
    @Override
     public void construirElevalunas() {
        this.coche.setElevalunasElec( true);
    }
}
