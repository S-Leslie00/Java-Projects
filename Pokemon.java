  public class Pokemon
  {
    //Name of the Pokemon
     private String name;
    //Amount of health for the Pokemon
     private int health; 
    //True or false value for Pokemon faint condition
     private boolean isFaint; 
    //True or false value for Pokemon evolution condition
    private boolean isEvolving; 

     //Builds a Pokemon when a name is provided.
    public Pokemon(String initName)
    {
      name = initName;
      health = 100;
      isFaint = false;
    }


     //Builds a Pokemon when a name is not provided (default)
    public Pokemon()
    {
        name = "Pikachu";
        health = 100;
        isFaint = false;
    }


     //Returns the current amount of health of the Pokemon
    public int getHealth()
    {
        return health;
    }


     //Returns the name of the Pokemon
    public String getName()
    {
       return name;
    }


     //Sets the name of the Pokemon
    public void setName(String newName)
    {
       name = newName;
    }



     //Reports true if the Pokemon has fainted and false otherwise.
    public boolean isFaint(String name, int health)
    {  
      if(health <= 0)
      {
          isFaint = true;
          System.out.println(name + " has fainted!");
      }
      

      else
      {
        System.out.println(name + " has " + health + " health left!");
        isFaint = false;
      }
      return isFaint;
     
    }

    //Pokemon has a chance to evolve into a new Pokemon if its health is 50 or above.
    public boolean isEvolving(int health)
    {
      isEvolving = false;
      if(health >= 50)
      {
        System.out.println("Your Pokémon has evolved!");
        health = 100;
        isEvolving = true;
      }
      return isEvolving;
    }


     //Heals the Pokemon a random amount between 0 and 25 inclusive
     public int heal(int health)
     {
       if (health <= 0)
        {
          health = 0;
          System.out.print(name + " healed for " + health + " points.       " );

        }
       else
       {
         int healPoints = (int)(Math.random()*26);
         if((health + healPoints) > 100)
         {
           health = 100;
           System.out.print(name + " healed for " + healPoints + " points.       " );
         }
         else
         {
           System.out.print(name + " healed for " + healPoints + " points.       " );
           health += healPoints;
         }

       }
       return health;

     }

     //Damages the Pokemon by a random amount between 0 and 50
     public int takeDamage(int health)
     {
       if(health <= 0)
       {
         health = 0;
         System.out.print(name + " took " + health + " points of damage.   " );
       }
       else
       {
         int damage = (int)(Math.random()*51);
          System.out.print(name + " took " + damage + " points of damage.   " );
          if((health-damage)<=0)
          {
            health = 0;

          }
          else
          {
            health -= damage;
          }

       }
       return health;

     }


  }//End of class
