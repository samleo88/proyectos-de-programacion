
import emuns.TipoPokemon;
import java.util.ArrayList;
import java.util.List;
import model.Entrenador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aaron
 */
public class UtilisMessages {
    
    public static String BREAKLINE = "\n";
    
    public void mostrarJugadores(List<Entrenador> entrenadors){
        StringBuilder builder = new StringBuilder();
        
        int cont = 1;
        for (Entrenador entrenador : entrenadors) {
            builder.append(cont + " - " + entrenador.getNombre()+ BREAKLINE);
            cont ++;
        }
        
        System.out.println(builder);
    }
    
    public void pokemonTypes(List<String> tipos){
        StringBuilder builder = new StringBuilder();
        int conta = 1;
        for (String tipoPokemon : tipos) {          
            builder.append(conta + " - " + tipoPokemon);
            conta++;
        }
        System.out.println(builder);
    }
    
    public void mostrarJugadoresSinPokemons(List<Entrenador> entrenadors){
        StringBuilder builder = new StringBuilder();
        
        int cont = 1;
        for (Entrenador entrenador : entrenadors) {
            if(entrenador.getPokemons() == null || entrenador.getPokemons().size() <= 2 ){
                builder.append(cont + " - " + entrenador.getNombre()+ BREAKLINE);
                cont ++;
            }            
        }
        
        System.out.println(builder);
    }
    
}
