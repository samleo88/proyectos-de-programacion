
import emuns.TipoPokemon;
import java.util.ArrayList;
import java.util.List;
import model.Entrenador;
import model.Pokemon;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aaron
 */
public class CampeonatoPokemon {
    
    public static List<Entrenador> entrenadores = new ArrayList<>();
    public static List<Entrenador> entrenadoresinPokemon = new ArrayList<>();

    public static List<String> tiposPokemon = new ArrayList<>();
    public static String BREAKLINE = "\n";
    public static int maxPokemon = 3;
    
    public static void main(String[] args) {
    
for (TipoPokemon pokemon : TipoPokemon.values()) {
           tiposPokemon.add(pokemon.toString()+BREAKLINE);
        }
        
        inscribirEntrenadores();
        
        
    }
    
    public static void menuprincipal(){
       Utils u = new Utils();
       UtilisMessages messages = new UtilisMessages();
            
       StringBuilder builder = new StringBuilder();
       builder.append("1 - Agregar nuevo entrador pokemon " + BREAKLINE)
               .append("2 - Asignar Pokemon" + BREAKLINE)
               .append("3 - Mostrar jugadores" + BREAKLINE);
        
       int value = u.getIntFromUser(builder.toString());
       
       switch(value){
           case 1:
               inscribirEntrenadores();
               break;
           case 2:
               asignarPokemons();
               break;
               
           case 3:
               messages.mostrarJugadores(entrenadores);
               menuprincipal();
               break;
               
       }
    }
    
    public static void inscribirEntrenadores(){
        Utils u = new Utils();
   
        boolean adddnew = true;
        
        while(adddnew){
            Entrenador e = new Entrenador();
            e.setNombre(u.getStringFromUser("Ingrese el nombre del "  + (entrenadores.size()+1) +"° entrenador:"));
            if(entrenadores.size() < 2){
                System.out.println("Debes inscribir minimo 6 entrendores");
            }else{
                System.out.println();
                
                int value = u.getIntFromUser("Deseas isncribir algun otro entrenador: " + BREAKLINE + ""
                        + "1 - Si" + BREAKLINE + ""
                        + "2 - No");
                
                switch (value){
                    
                    case 1: 
                        adddnew = true;
                        break;
                        
                    case 2: 
                        adddnew = false;
                        break;
                        
                    default:
                        System.out.println("Sera redirigido al menu principal");
                        menuprincipal();
                }
                                
            }
            entrenadores.add(e);
        }
        menuprincipal();
    }
    
    public static void asignarPokemons(){
        System.out.println(BREAKLINE + "Solo se puede asignar un maximo de (" + maxPokemon + ") pokemons" + BREAKLINE + ""
                + "Nota: Los movimientos seran asignados aleatoriamente" + BREAKLINE);
        
        UtilisMessages messages = new UtilisMessages();
        Utils utils = new Utils();
        reviarEntrenadores();
        messages.mostrarJugadoresSinPokemons(entrenadoresinPokemon);
        
        int value = utils.getIntFromUser("Seleccione una opcion:");
       
        int pokSele = 0;
        
        List<Pokemon> pokemons = new ArrayList<>();
        
        if(entrenadoresinPokemon.get(value-1).getPokemons() != null){
            pokSele = entrenadoresinPokemon.get(value-1).getPokemons().size();
            pokemons = entrenadoresinPokemon.get(value-1).getPokemons();
        }
        
        while(pokSele <= 2 ){
            Pokemon pokemon = new Pokemon();
            pokemon.setNombre(utils.getStringFromUser(BREAKLINE + "Digite el nombre del pokemon"));
            messages.pokemonTypes(tiposPokemon);
            int pokemonType = utils.getIntFromUser("Seleccione un tipo de pokemon: ");
            
            while(pokemonType > tiposPokemon.size()){
                System.err.println("Error seleccione un tipo valido");
                pokemonType = utils.getIntFromUser("Seleccione un tipo de pokemon: ");
            }
            
            //pokemon.setTipo(TipoPokemon.valueOf(tiposPokemon.get(pokemonType-1)));//
            
            String type = tiposPokemon.get(pokemonType-1).replace(BREAKLINE, "");
            pokemon.setTipo(TipoPokemon.valueOf(type));
            
            pokemon.setNivel(1);
            
            pokemons.add(pokemon);
            
            pokSele++;
                    
        }
       
        agregarpokemons(value-1, pokemons);
        if(!allhasPokemon()){
            System.out.println("Debes agregar los pokemon de todos los entranadores" + BREAKLINE + ""
                    + "Selecciona un nuevo jugador para asignar sus pokemones");
            
            asignarPokemons();
        }
        
        
    }
    
    public static void agregarpokemons(int index, List<Pokemon> pokemons){
        for (Entrenador entranadore : entrenadores) {
            if(entranadore.getNombre().equals(entrenadoresinPokemon.get(index).getNombre())){
                entranadore.setPokemons(pokemons);
            }
        }
    }
    
    public static boolean existeEntrenador(String name){
        for (Entrenador entranadore : entrenadores) {
            if(entranadore.getNombre().equals(name)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean allhasPokemon(){
        for (Entrenador entranadore : entrenadores) {
            if(entranadore.getPokemons() == null || entranadore.getPokemons().size() <= 2){
                return false;
            }
        }
        return true;
    }
    
    public static void reviarEntrenadores(){
           entrenadoresinPokemon = new ArrayList<>();
           for (Entrenador entranadore : entrenadores) {
            if(entranadore.getPokemons() == null || entranadore.getPokemons().size() <= 2){
                entrenadoresinPokemon.add(entranadore);
            }
        }
    }
    
    
}
