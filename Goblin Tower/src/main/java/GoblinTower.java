import java.lang.Math;
import java.util.Scanner;

public class GoblinTower {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        //Character c = new Character();
        boolean playAgain = false;
        int gold = 0;
        int gameLevel = 0;
        int steps = 0;

        do{
            Hero h = new Hero();
            int maxHealth = (int) ((Math.random() * (30 - 20)) + 20);
            int currentHealth = maxHealth;
            int attackPower = (int) ((Math.random() * (3 - 1)) + 1);
            int defensePower = (int) ((Math.random() * (5 - 1)) + 1);

            h.setStats(maxHealth, currentHealth, attackPower, defensePower);
            System.out.println("Hero has been created." +
                    "\nMax Health: " + h.getMaxHealth() +
                    "\nCurrent Health: " + h.getHealth() +
                    "\nAttack Power: " + h.getAttackPower() +
                    "\nDefense Power: " + h.getDefensePower());
            boolean alive = true;
            do{
                System.out.println("\nEnter any key followed by an ENTER to move the Hero one step:");
                String userResponse = userInput.nextLine();
                switch (userResponse){
                    case "quit":
                        playAgain = false;
                        alive = false;
                        break;
                    default:
                        //System.out.println("Response: " + userResponse);
                        System.out.println("A step forward was taken by the Hero.");
                        steps++;
                        break;
                }

                if (steps % 10 == 0){
                    gameLevel++;
                    System.out.println("\nLevel up! Current level: " + gameLevel);
                    System.out.println("\nWould you like to enter the potion shop? [yes|no]");
                    System.out.println("Your current gold is: " + gold + " gold ingots.");
                    userResponse = userInput.nextLine();
                    if (gold > 4) {
                        switch (userResponse) {
                            case "yes":
                                gold = gold - 4;
                                System.out.println("You bought a potion! Your current gold is: " + gold + " gold ingots.");
                                break;
                            case "quit":
                                playAgain = false;
                                alive = false;
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        System.out.println("You're broke. Get out my shop.");
                    }
                }

                int goblinChance = (int) ((Math.random() * (5 - 1)) + 1); // 1, 2 ,3 , 4, 5
                if (goblinChance == 1 || goblinChance == 5){ // Goblin Appears if 1 or 5 was selected.
                    // ask user if they want to heal.
                    // heal user till max health only no more than max health
                    // how many potion do they want to use?
                    // might have to use ArrayList instead of arrays for potion as ArrayList is dynamic.
                    int g_maxHealth = (int) ((Math.random() * (10 - 5)) + 5);
                    int g_currentHealth = g_maxHealth;
                    int g_attackPower = (int) ((Math.random() * (3 - 2)) + 2);
                    int g_defensePower = (int) ((Math.random() * (2 - 1)) + 1);
                    Goblin g = new Goblin();
                    g.setStats(g_maxHealth, g_currentHealth, g_attackPower, g_defensePower);
                    System.out.println("A Goblin has appeared!" +
                            "\nMax Health: " + g.getMaxHealth() +
                            "\nCurrent Health: " + g.getHealth() +
                            "\nAttack Power: " + g.getAttackPower() +
                            "\nDefense Power: " + g.getDefensePower());

                    while (h.getHealth() > 0 && g.getHealth() > 0){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (h.getHealth() <= 0){
                            alive = false;
                        }
                        else{
                            System.out.println("\nHero attacked Goblin with " + h.getAttackPower() + " attack points!");
                            g.damage(h.getAttackPower());
                            System.out.println("Goblin's Health: " + g.getHealth() + "/" + g.getMaxHealth());

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if (g.getHealth() <= 0){
                                System.out.println("\nGoblin fainted.");
                                System.out.println("Congratulation! You've gained 2 gold!");
                                gold = gold + 2;
                                System.out.println("\nYour health is: " + h.getHealth() + "/" + h.getMaxHealth());
                                System.out.println("Do you want to heal? You have " + h.getPotion() + " potions. [yes|no]");
                                userResponse = userInput.nextLine();

                                switch(userResponse){
                                    case "yes":
                                        System.out.println("How many potions would you like to use? [0-5]");
                                        int userResponseInt = userInput.nextInt();
                                        h.usePotion(userResponseInt);
                                        userResponse = userInput.nextLine();
                                        System.out.println("\nYour health is now: " + h.getHealth() + "/" + h.getMaxHealth());
                                        System.out.println("\nYou have : " + h.getPotion() + " potion(s) left.");
                                        break;
                                    default:
                                        break;
                                }
                            }
                            else{
                                System.out.println("\nGoblin attacked Hero with " + g.getAttackPower() + " attack points!");
                                h.damage(g.getAttackPower());
                                System.out.println("Hero's Health: " + h.getHealth() + "/" + h.getMaxHealth());

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                if (h.getHealth() <= 0){
                                    System.out.println("\nHero fainted.");
                                    alive = false;
                                }
                            }
                        }
                    }

                }

            }while(alive);





            System.out.println("\nWould you like to continue playing (Gold remain the same) [yes|no]?:");
            String userResponse = userInput.nextLine();

            switch (userResponse){
                case "yes":
                    playAgain = true;
                    break;
                case "no":
                    playAgain = false;
                    break;
                default:
                    System.out.println("Invalid Response: " + userResponse);
                    playAgain = false;
                    break;
            }
        }while(playAgain);
    }
}
