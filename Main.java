import java.util.Scanner;
import java.util.Random; 
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main {
   public static void main(String[] args) {
        //declare variables & call on construtor of pokemon, pokedex, gamestate objects 
        Pokedex dex = new Pokedex();
        Pokemon p[] = dex.getPokedex();
        GameState gs = new GameState();
        // declare player 
        Pokemon playerStarter = new Pokemon();
        int choose = gs.chosenPokemon();
        playerStarter = p[choose];
        
        //generate random number to select index of opponent
        int oppNum = getRandom(p);
        Pokemon opponent = new Pokemon();
        opponent = p[oppNum];
        System.out.println("Your opponent is " + opponent.getName() + ", a " + opponent.getType() + " type pokemon!");
        
        int gameResult = gs.battle(playerStarter, opponent);
        
        Scanner input = new Scanner(System.in);
        while (gameResult == 0) {
            System.out.println("Play again? Y/N");
            String playAgain = input.nextLine();
            if (playAgain.equals("Y")) {
                gs.chosenPokemon();
                oppNum = getRandom(p);
                opponent = p[oppNum];
                System.out.println("Your opponent is " + opponent.getName() + ", a " + opponent.getType() + " type pokemon!");
                gs.battle(playerStarter, opponent);
            } else {
                gameResult = 1;
            }
        }
   }
    
   /**
    * Get random index to randomize opponent.
    *
    * @param  
    * @return  a random #
    */
   public static int getRandom(Pokemon[] pokedex) {
        Random rand = new Random(System.currentTimeMillis());
        int randomNum = rand.nextInt(pokedex.length);
        return randomNum;
   }
}