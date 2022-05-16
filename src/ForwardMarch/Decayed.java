package ForwardMarch;

public class Decayed extends Enemy{

    public Decayed()
    {
        baseStats();
    }

    public void baseStats()
    {
        setRegenStrategy(new Decay());
        setMaxHealth(30);
        setStrength(5);
        setDefense(10);
        setSpeed(6);
        setLuck(20);
        setHealth(getMaxHealth());
        resetHitChance();
    }
}
