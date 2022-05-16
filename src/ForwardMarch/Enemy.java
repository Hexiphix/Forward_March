package ForwardMarch;

public class Enemy {
    private int health, maxHealth, strength, defense, speed, luck; //intelligence;

    //Determines how and if the enemy regenerates
    private RegenStrategy regenStrategy;

    //Data that constantly shifts bases on the other data points;
    //private int mana, maxMana;
    private double hitChance;


    //Space for all stat to be get, set, and reset

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLuck() {
        return luck;
    }
    public void setLuck(int luck) {
        this.luck = luck;
    }

    public RegenStrategy getRegenStrategy() {
        return regenStrategy;
    }
    public void setRegenStrategy(RegenStrategy regenStrategy) {
        this.regenStrategy = regenStrategy;
    }

    public double getHitChance() {
        return hitChance;
    }
    public void setHitChance(double hitChance) {
        this.hitChance = hitChance;
    }
    public void resetHitChance(){
        if(luck <= 1) {
            hitChance = 0;
        }
        else {
            hitChance = (1.0 - (100.0 / luck));
        }
    }
}
