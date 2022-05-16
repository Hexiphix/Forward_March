package ForwardMarch;

public class Zombie extends Enemy{

    public void baseStats()
    {
        setRegenStrategy(new SmallRegen());
        setMaxHealth(30);
        setStrength(7);
        setDefense(4);
        setSpeed(6);
        setLuck(7);
        setHealth(getMaxHealth());
        resetHitChance();
    }
}
