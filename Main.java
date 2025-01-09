// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

import java.util.Scanner;
public class Main 
{
   public static void main(String [] args)
   {
      // Create a Scanner Object to read from the Pokemon class.
      Scanner scanner = new Scanner(System.in);

      // Create a Pokemon with a name of the users choosing.
      System.out.println("What would you like to name your Pokémon?");
      Pokemon pokemon_1 = new Pokemon(scanner.nextLine());
      
      // Print out Your Pokemon <insert name> has been created!
      System.out.println("Your Pokémon " + pokemon_1.getName() + " has been created!");

      System.out.println("What is the name of your opponent?");
      Pokemon pokemon_2 = new Pokemon(scanner.nextLine());
      System.out.println("Your opponent is " + pokemon_2.getName() + "!");

      int pokemon_1_health = pokemon_1.getHealth();
      int pokemon_2_health = pokemon_2.getHealth();

      boolean pokemon_1_faint = pokemon_1.isFaint(pokemon_1.getName(), pokemon_1_health);
      boolean pokemon_2_faint = pokemon_2.isFaint(pokemon_2.getName(), pokemon_2_health);
      
      while(pokemon_1_faint == false && pokemon_2_faint == false)
         {
            //4. Print out the menu of options the user can take.
            System.out.println("What would you like to do?\n 1)Attack\n 2)Heal");
            
            String user_choice = scanner.nextLine();
            
            //If the user chooses to attack, call the takeDamage method on the Pokemon they are fighting.
            if(user_choice.equals("1"))
               {
                  pokemon_2_health = pokemon_2.takeDamage(pokemon_2_health);
                  pokemon_2_faint = pokemon_2.isFaint(pokemon_2.getName(), pokemon_2_health);
                  if(pokemon_2_faint == false)
                     {
                        pokemon_1_health = pokemon_1.takeDamage(pokemon_1_health);
                        pokemon_1_faint = pokemon_1.isFaint(pokemon_1.getName(), pokemon_1_health);
                     }
                  
               }
            //If the user chooses to heal, call the heal method on the Pokemon they are using.
            else if(user_choice.equals("2") && pokemon_1_health > 0)
               {
                  pokemon_1_health = pokemon_1.heal(pokemon_1_health);
                  pokemon_1_health = pokemon_1.takeDamage(pokemon_1_health);
                  pokemon_1_faint = pokemon_1.isFaint(pokemon_1.getName(), pokemon_1_health);
               }

            else
            {
               System.out.println("Enter a valid option.");
            }
            
         }
      pokemon_1.isEvolving(pokemon_1_health);
