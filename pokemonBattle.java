import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * pokemon battle class includes battle method which determines the damage pokemon can do based on it's type, simulates the 
 * battle, and returns the winner. also includes a chosen pokemon method which calls the begining of the game where pokemon 
 * is asked for and assigns it to  corresponding pokemon object.
 *
 * @author emily
 * @version 4/22/2022
 */
public class pokemonBattle
{    
    public int chosenPokemon() {
        //declare variables & call on construtor of pokemon and pokedex objects 
        Pokedex dex = new Pokedex();
        Pokemon p[] = dex.getPokedex();
        // declare player and ask user which pokemon they would like to play
        Pokemon playerStarter = new Pokemon();
        Scanner input = new Scanner(System.in);
        String myPokemon;
        
        // find out if input matches name in pokedex if not a match, ask again
        boolean valid = false;
        int temp = 0;
        do {
            try {
                System.out.println("Choose your pokemon! "+p[0].getName()+", "+p[1].getName()+", "+p[2].getName()+", "+
                p[3].getName()+", "+p[4].getName()+", "+ p[5].getName()+", "+p[6].getName()+", "+p[7].getName()+", "+p[8].getName()+", or "+
                p[9].getName());
                myPokemon = input.nextLine();
                for (int i = 0; i < p.length; i++) {
                    if (myPokemon.equals(p[i].getName())) {
                        playerStarter = p[i];
                        valid = true;
                        temp = i;
                        System.out.println("You have chosen " + myPokemon + ", a " + playerStarter.getType() + " type pokemon!");
                }
                } 
                if (valid == false) {
                System.out.println("Invalid entry.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid entry.");
            }        
            }
         while (!valid);
        return temp;
    }
    public int battle(Pokemon starter, Pokemon opp) {
        //get variables
        int oppHealth = opp.getHP();
        int playHealth = starter.getHP();
        int playAttack = starter.getAttackPts();
        int oppAttack = opp.getAttackPts();
        
        //varaible for turn switch
        int turn = 1;
        
        //water type more effective agaisnt fire type
        //fire type more effective against grass type
        //electric type more effective against water type
        //grass type more effective agaisnt water type
        //dragon type more effective against itself
        
        //so when these types are against eachother add more attack points to the most effective type
        if (starter.getType().equals("water") && opp.getType().equals("fire")) {
            playAttack = playAttack + 20;
        } else if (opp.getType().equals("water") && starter.getType().equals("fire")) {
            oppAttack = oppAttack + 20;
        } else if (starter.getType().equals("fire") && opp.getType().equals("grass")) {
            playAttack = playAttack + 20;
        } else if (opp.getType().equals("fire") && starter.getType().equals("grass")) {
            oppAttack = oppAttack + 20;
        } else if (starter.getType().equals("electric") && opp.getType().equals("water")) {
            playAttack = playAttack + 20;
        } else if (opp.getType().equals("electric") && starter.getType().equals("water")) {
            oppAttack = oppAttack + 20;
        } else if (starter.getType().equals("grass") && opp.getType().equals("water")) {
            playAttack = playAttack + 20;
        } else if (opp.getType().equals("grass") && starter.getType().equals("water")) {
            oppAttack = oppAttack + 20;
        } else {
            playAttack = playAttack;
            oppAttack = oppAttack;
        }
        
        //the pokemon with higher speed will go first
        if (starter.getSpeed() > opp.getSpeed()) {
            System.out.println(starter.getName() + " will go first.");
        } else if (starter.getSpeed() < opp.getSpeed()) {
            System.out.println(opp.getName() + " will go first.");
            turn = 2;
        } else if (starter.getSpeed() == opp.getSpeed()) {
            System.out.println(starter.getName() + " will go first.");
        }
        
        //Battle
        //when battle decided = true, the battle is over
        boolean battleDecided = false;
        while (!battleDecided){
            //When either pokemon reaches 0 health, print to the user if they have won the battle or not.
            if (playHealth <= 0 && oppHealth >= 1) {
                System.out.println("Your pokemon, " + starter.getName() + " lost.");
                battleDecided = true;
            } else if (playHealth >= 1 && oppHealth <= 0) { 
                System.out.println( "Woohoo! Your pokemon, " + starter.getName() + " won!");
                battleDecided = true;
            }
            //if turn equals to 1, it is the users turn
            //subtract pokemons attck pts from their opponents health pts
            if (turn == 1 && !battleDecided) {
                oppHealth = oppHealth - playAttack;
                System.out.println(starter.getName() + " did " + playAttack + " damage to " + opp.getName() + ".");
                if (oppHealth >= 1) {
                    System.out.println(starter.getName() + " HP: " + playHealth);
                    System.out.println(opp.getName() + " HP: " + oppHealth);
                }
                // switch to opponents turn
                turn = 2;
            }
            // if either players health reaches 0 at this point, return to first condition
            if (oppHealth <= 0 || playHealth <= 0) {
                continue;
            }
            if (turn == 2 && !battleDecided) {
                playHealth = playHealth - oppAttack;
                System.out.println(opp.getName() + " did " + oppAttack + " damage to " + starter.getName() + ".");
                if (playHealth >= 1) {
                    System.out.println(starter.getName() + " HP: " + playHealth);
                    System.out.println(opp.getName() + " HP: " + oppHealth);
                }
                //switch to users turn
                turn = 1;
            }
        }
        return 0;
    }
}