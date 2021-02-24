import java.util.ArrayList;

public class Hero extends Character{
    private ArrayList<Integer> potions = new ArrayList<Integer>();

    public Hero(){
        for (int i = 1; i <= 5; i++) {
            this.potions.add(2);
            //System.out.println("Adding potion #" + i);
        }
    }

    public int getPotion(){
        return this.potions.size();
    }

    public void usePotion(int numberPotions){
        if (this.potions.size() >= numberPotions){
            for (int i = 0; i < numberPotions; i++) {
                this.potions.remove(0);
                this.heal(2);
                //System.out.println("Using potion #" + (i + 1));
            }
        }
        else{
            System.out.println("\nYou do not have enough potions.");
        }
    }
}
