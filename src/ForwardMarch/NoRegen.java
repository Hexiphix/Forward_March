package ForwardMarch;

public class NoRegen implements RegenStrategy{
    @Override
    public int regenerate(int enemyMaxHealth) {
        return 0;
    }
}
