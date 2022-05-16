package ForwardMarch;

public class Main {

    public static void main(String[] args) {
        //Keeps everything outside the Main File, and makes a Game singleton
        Game.getInstance().beginGame();
    }
}