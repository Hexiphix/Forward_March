package ForwardMarch;

public class KingGoblin extends Enemy{

    public void baseStats()
    {
        setRegenStrategy(new NoRegen());
        setMaxHealth(2000);
        setStrength(700);
        setDefense(700);
        setSpeed(1200);
        setLuck(1400);
        setHealth(getMaxHealth());
        resetHitChance();
    }
}
