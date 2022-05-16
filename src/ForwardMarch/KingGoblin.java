package ForwardMarch;

public class KingGoblin extends Enemy{

    public KingGoblin()
    {
        baseStats();
    }

    public void baseStats()
    {
        setRegenStrategy(new SmallRegen());
        setMaxHealth(2000);
        setStrength(700);
        setDefense(700);
        setSpeed(1200);
        setLuck(1400);
        setHealth(getMaxHealth());
        resetHitChance();
    }
}
