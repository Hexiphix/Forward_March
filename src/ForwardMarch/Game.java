package ForwardMarch;

public class Game {
    private static Game instance = null;

    private Game() {
        try {
            // Simulate a long-running constructor, maybe a network or database call?
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException ex) {
        }

        System.out.println("Game instance created ");
        System.out.println(this);
    }
    //Creates a Game singleton
    public static Game getInstance(){
        if(instance == null) {
            instance = new Game();
        }

        return instance;
    }

    public void beginGame(){
        instance.runGame();
    }

    //runs game functions
    private void runGame(){
        getPlayer().formatDefaultPlayer();
        //while
    }

    //gets the player instance
    private Player getPlayer(){
        return Player.getInstance();
    }
}
