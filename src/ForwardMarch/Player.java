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
}
