package ForwardMarch;

public class Goblin extends Enemy{

    public void baseStats()
    {
        setRegenStrategy(new SmallRegen());
        setMaxHealth(20);
        setStrength(7);
        setDefense(7);
        setSpeed(12);
        setLuck(14);
        setHealth(getMaxHealth());
        resetHitChance();
    }
}
