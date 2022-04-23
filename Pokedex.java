/**
 * pokedex class contains a list of pokemon objects which can be altered, added to, or removed. 
 *
 * @author emily
 * @version 4/22/2022
 */

public class Pokedex 
{
    private Pokemon p[];
    public Pokedex () {
        Pokemon[] pokedex = new Pokemon[10];
        
        pokedex[0] = new Pokemon("Ninetales","fire", 100, 100, 30);
        pokedex[1] = new Pokemon("Squirtle", "water", 70, 43, 10);
        pokedex[2] = new Pokemon("Garchomp", "dragon", 120, 102, 40);
        pokedex[3] = new Pokemon("Charmander", "fire", 80, 65, 20);
        pokedex[4] = new Pokemon("Chikorita", "grass", 90, 45, 25);
        pokedex[5] = new Pokemon("Pikachu", "electric", 90, 90, 25);
        pokedex[6] = new Pokemon("Dragonite", "dragon", 95, 80, 35);
        pokedex[7] = new Pokemon("Blastoise", "water", 85, 78, 30);
        pokedex[8] = new Pokemon("Ampharos", "electric", 100, 55, 25); 
        pokedex[9] = new Pokemon("Bulbasaur", "grass", 70, 45, 20);
        
        p = pokedex;
    }
    public Pokemon[] getPokedex() {
        return p;
    }
}
