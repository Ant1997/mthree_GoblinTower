public class Character {
    private int maxHealth;
    private int currentHealth;
    private int attackPower;
    private int defensePower;

    public int getMaxHealth(){
        return this.maxHealth;
    }

    public int getHealth(){
        return this.currentHealth;
    }

    public int getAttackPower(){
        return this.attackPower;
    }

    public int getDefensePower(){
        return this.defensePower;
    }

    public void setStats(int maxHealth, int currentHealth, int attackPower, int defensePower){
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public void damage(int dmg){
        this.currentHealth = this.currentHealth - dmg;
        //System.out.println("Damage done.");
    }

    public void heal(int hl){
        this.currentHealth += hl;
        if (this.currentHealth > this.maxHealth){
            this.currentHealth = this.maxHealth;
        }
    }
}
