import java.util.Random;

/**
 * Pokemon Class Constructor
 *
 * @author emily
 * @version 4/22/2022
 */
public class Pokemon
{  
    //initialize pokemon objects 
    private String name;
    private String type;
    private int hp;
    private int speed;
    private int attack;

    ///pokemon contructor contains name of pokemon and their type, speed, health points, and attack points.
    public Pokemon() {}
    public Pokemon(String n, String t, int hp, int sp, int a) {
        this.name = n;
        this.type = t;
        this.hp = hp;
        this.speed = sp;
        this.attack = a;
    }

    //Getter methods
    /**
     * Gets name of pokemon.
     *
     * @param 
     * @return name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Gets type of pokemon.
     *
     * @param  
     * @return type
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * Gets pokemon's hp.
     *
     * @param 
     * @return hp #
     */
    public int getHP()
    {
        return this.hp;
    }

    /**
     * Gets speed of pokemon.
     *
     * @param  
     * @return speed #
     */
    public int getSpeed()
    {
        return this.speed;
    }

    /**
     * Get damage of attack.
     *
     * @param  
     * @return  damage #
     */
    public int getAttackPts()
    {
        return this.attack;
    }
}
         

