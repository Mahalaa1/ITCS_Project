import java.util.Random;
import java.util.Scanner;

public class Battle
{

    public void battle() //contains how the classes interact with each other during battle
    {
        //Objects for battle class
        Scanner kb = new Scanner(System.in);
        Random rand = new Random();

        /*------------------------------------
                    PLACEHOLDERS
          ------------------------------------*/

        //Variables for battle
        String[] enemies = {"Customer","Gourd Monster"};
        int maxEnemyHealth = 75;
        int enemyAtkDmg = 25;

        //Player variables
        int health = 100;
        int atkDmg = 50;
        int numPotions = 3;
        int potionHealAmount = 30;
        int potionDropChance = 50; //percent

        //------------------------------------

        boolean running = true;//while the boolean is true the game is running

        System.out.println("You've made it to level:" + " |INSERT LEVEL NUMBER HERE|");

        GAME:
        while(running)
        {
            System.out.println("------------------------------------------");

            //initializing the enemy and its health
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];

            //telling the player what enemy they are fighting
            System.out.println("\t# " + enemy + " appeared! #\n");

            //while the enemy is not dead
            while(enemyHealth > 0)
            {
                //telling the user there health and the enemy's health
                //also giving them options for what they can do
                System.out.println("\tYour HP:" + health);
                System.out.println("\t" + enemy + "'s HP:" + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Health Potion");
                System.out.println("\t3. RUN!");

                //taking the users input
                String input = kb.nextLine();

                //if the user inputs 1 => attack
                if(input.equals("1"))
                {
                    //initializing dealt and taken dmg
                    int dmgDealt = rand.nextInt(atkDmg);
                    int dmgTaken = rand.nextInt(enemyAtkDmg);

                    //subtracting the dealt and taken dmg from player and enemy's health
                    enemyHealth -= dmgDealt;
                    health -= dmgTaken;

                    //letting the user know what just happened
                    System.out.println("\t> You strike the " + enemy + " for " + dmgDealt + " damage.");
                    System.out.println("\t> You were hit for " + dmgTaken + " damage!");

                    //if the user dies during the attack
                    if(health < 1)
                    {
                        //tell them they died and break out of the loop
                        System.out.println("\t> You have taken too much damage, you are dead...");
                        break;
                    }

                }
                //if the user inputs 2 => health pot
                else if(input.equals("2"))
                {
                    //if they have more than 0 potions
                    if(numPotions > 0)
                    {
                        //adding on to their health and subtracting the number of potions in there inventory
                        health += potionHealAmount;
                        numPotions --;
                        //letting the user know what happened
                        System.out.println("\t> You drink a health potion, it healed you by " + potionHealAmount + "HP."
                                + "\n\t>You now have " + health + " HP."
                                + "\n\t> You have " + numPotions + " health potions left.\n");
                    }
                    //if they have no potions left
                    else
                    {
                        //let the player know they don't have any
                        System.out.println("\t> You have no health potions left! Defeat enemies to have a chance to get more.");
                    }

                }
                //if the user inputs 3 => run from the enemy into another one
                else if(input.equals("3"))//run
                {
                    //tells the user what happened
                    System.out.println("\t You run away from the " + enemy + "!");
                    //brings the player to the top of the loop GAME
                    continue GAME;
                }
                // if the user inputs something other than 1,2, or 3
                else
                {
                    //tell them they have input the wrong thing
                    System.out.println("\tInvalid Command");

                }

            }

            //if the user dies
            if(health < 1)
            {
                //tell them they have died and break out of the game loop
                System.out.println("The Prince of Produce has won! Do better next time!");
                break;
            }
            //letting the user know what happened
            System.out.println("------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + health + " HP left. # ");

            //potion drop chance
            if(rand.nextInt(100) < potionDropChance)
            {
                //adds one potion to the players inventory and tells them what happened
                numPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion! #");
                System.out.println(" # You now have " + numPotions + " health potion(s) # ");
            }

            //asks the user what to do next
            System.out.println("------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Give up (the gourds are too strong for me)");

            //taking user input
            String input = kb.nextLine();

            //if the user inputs anything other than 1 or 2
            while(!input.equals("1") && !input.equals("2"))
            {
                //tell them it's an invalid command and take their input until it's valid
                System.out.println("Invalid Command!");
                input = kb.nextLine();
            }

            //if they input 1 => continue fighting
            if(input.equals("1"))
            {
                System.out.println("You continue on your journey to destroy the Prince of Produce!");
            }
            //if they input 2 => give up
            else if(input.equals("2"))
            {
                System.out.println("You made it out alive, but the Prince of Produce lives on!");
                break;
            }

        }
    }


}
