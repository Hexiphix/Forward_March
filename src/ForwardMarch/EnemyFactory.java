package ForwardMarch;

public class EnemyFactory {

    public Enemy getEnemy(String enemyType) {
        switch (enemyType) {
            case "goblin":
                return new Enemy();
            case "zombie":
                return new Enemy();
            case "decayed":
                return new Enemy();
        }
        return null;
    }
}
