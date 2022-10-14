/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import emuns.TipoPokemon;
import emuns.movimientos;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author 
 */
public class Pokemon {
    private String nombre;
    private int nivel;
    private TipoPokemon tipo;
    List <movimientos> movimoentos = new ArrayList<>();
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }   
}
