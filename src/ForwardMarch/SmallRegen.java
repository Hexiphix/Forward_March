package ForwardMarch;

public class SmallRegen implements RegenStrategy{
    @Override
    public int regenerate(int enemyMaxHealth) {
        return ((int)(Math.round(0.05 * enemyMaxHealth)));
    }
}
