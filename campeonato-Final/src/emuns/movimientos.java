/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emuns;

/**
 *
 * @author aaron
 */
public enum movimientos {

    COLA_DE_DRAGON(10,TipoPokemon.AGUA), COMBATE(50,TipoPokemon.AGUA), HIDROCAÑON(100,TipoPokemon.AGUA),
    GIRO_FUEGO(10,TipoPokemon.FUEGO), LANZALLAMAS(50,TipoPokemon.FUEGO),  RUEDA_FUEGO(100,TipoPokemon.FUEGO),
    DISPARO_LODO(10,TipoPokemon.TIERRA), TERREMOTO(50,TipoPokemon.TIERRA),  FILO_DEL_ABISMO(100,TipoPokemon.TIERRA),
    IMPACTRUENO(10,TipoPokemon.ELECTRICO),  RAYO(50,TipoPokemon.ELECTRICO),  PUÑO_TRUENO(100,TipoPokemon.ELECTRICO),
    LANZARROCAS(10,TipoPokemon.ROCA), AVALANCHA(50,TipoPokemon.ROCA),  PEDRADA(100,TipoPokemon.ROCA),
    PICOTAZO(10,TipoPokemon.VOLADOR), VENDAVAL(50,TipoPokemon.VOLADOR),  GOLPE_AEREO(100,TipoPokemon.VOLADOR),
    ACIDO(10,TipoPokemon.VENENO), RESIDUOS(50,TipoPokemon.VENENO),  VENENO_X(100,TipoPokemon.VENENO),
    LATIGO_CEPEDA(10,TipoPokemon.PLANTA), ENERGIBOLA(50,TipoPokemon.PLANTA),  TORMENTA_FLORAL(100,TipoPokemon.PLANTA),
    INFORTUNIO(10,TipoPokemon.FANTASMA), TINIEBLAS(50,TipoPokemon.FANTASMA),  BOLA_SOMBRA(100,TipoPokemon.FANTASMA);

    private final int daño;
    private final TipoPokemon tipoPokemon;

    movimientos(int daño, TipoPokemon tipoPokemon) {
        this.daño = daño;
        this.tipoPokemon = tipoPokemon;
    }
    private int daño() { return daño; }
    private TipoPokemon tipoPokemon(){ return tipoPokemon;}
    
}
