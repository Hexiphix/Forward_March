package ForwardMarch;

public class EnemyFactory {

    public Enemy getEnemy(String enemyType) {
        switch (enemyType) {
            case "goblin":
                return new Goblin();
            case "zombie":
                return new Zombie();
            case "decayed":
                return new Decayed();
            case "primalMonster":
                return new KingGoblin();
        }
        return null;
    }
}
