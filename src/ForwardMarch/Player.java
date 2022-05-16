package ForwardMarch;

public class Player {
    private static Player instance = null;

    //Data that changes with each room boost
    private int health, maxHealth, strength, defense, intelligence, speed, luck;

    //Data that only changes if an accessory lets it do so
    private double healthRegenRate, manaRegenRate;

    //Data that constantly shifts bases on the other data points;
    private int mana, maxMana;
    private double critChance, critDamage, evasionChance;

    private Player() {
        try {
            // Simulate a long-running constructor, maybe a network or database call?
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException ex) {
        }

        System.out.println("Player instance created ");
        System.out.println(this);
    }
    //Creates a Game singleton
    public static Player getInstance(){
        if(instance == null) {
            instance = new Player();
            instance.setPlayerDefaults();
        }

        return instance;
    }

    public void formatDefaultPlayer(){
        instance.setPlayerDefaults();
    }

    private void setPlayerDefaults(){
        maxHealth = 20;
        health = maxHealth;
        strength = 10;
        defense = 10;
        intelligence = 10;
        speed = 10;
        luck = 10;

        healthRegenRate = 0.05;
        manaRegenRate = 0.1;

        maxMana = intelligence;
        mana = maxMana;

        critChance = (luck/100.0);
        critDamage = 2.0;
        if(luck < 400) {
            evasionChance = (luck / 1000.0);
        }
        else {
            evasionChance = 0.4;
        }
    }

    //Space for all stat to be get, set, and reset

    //Starting with the 6 level stats
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

    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
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

    //Stats that are not naturally improved by level
    public double getHealthRegenRate() {
        return healthRegenRate;
    }
    public void setHealthRegenRate(double healthRegenRate) {
        this.healthRegenRate = healthRegenRate;
    }

    public double getManaRegenRate() {
        return manaRegenRate;
    }
    public void setManaRegenRate(double manaRegenRate) {
        this.manaRegenRate = manaRegenRate;
    }

    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }

    //Commands that are dependent on other stats and can be reset
    public int getMaxMana() {
        return maxMana;
    }
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }
    public void resetMaxMana(){
        maxMana = intelligence;
    }

    public double getCritChance() {
        return critChance;
    }
    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }
    public void resetCritChance(){
        if(luck >= 100) {
            critChance = 1.0;
        }
        else {
            critChance = (luck / 100.0);
        }
    }

    public double getCritDamage() {
        return critDamage;
    }
    public void setCritDamage(double critDamage) {
        this.critDamage = critDamage;
    }
    public void resetCritDamage(){
        if(luck < 100) {
            critDamage = 2.0;
        }
        else {
            critDamage = (1.0 + (luck / 100.0));
        }
    }

    public double getEvasionChance() {
        return evasionChance;
    }
    public void setEvasionChance(double evasionChance) {
        this.evasionChance = evasionChance;
    }
    public void resetEvasionChance(){
        if(luck < 400) {
            evasionChance = (luck / 1000.0);
        }
        else {
            evasionChance = 0.4;
        }
    }
}
