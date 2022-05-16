package ForwardMarch;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Game instance = null;

    private int randInt;
    private double randDouble;
    Random theRandom = new Random();
    Scanner playerInput = new Scanner(System.in);

    private int playerNumberInput = 0;
    private boolean bossDefeated = false;
    private int positionsToLeft = 0;
    private int stage = 1;
    private Direction previousDirection = Direction.FORWARD;

    private EnemyFactory enemyFactory;
    private Enemy enemy1;
    private String enemy1Title;

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
        System.out.println();
        System.out.println("Welcome to Forward March, there are three goals you can pursue in this game:");
        System.out.println("1. Head ten turns to the left plus how ever many right turn you took, to fight the boss, a tough enemy who keeps the monsters in line");
        System.out.println("2. Turn right for as long as you want, see how powerful you can get by amassing huge amounts of accessories");
        System.out.println("3. March Forward as far as you can go, fighting increasingly tough enemies until they are too tough to handle\n");
        System.out.println("While the rules and systems behind these features are supposed to be more complicated, \n" +
                "   they unfortunately must me moved to be worked on at a later date, so feel free to move as you please, \n" +
                "   any direction at any time, other than going backwards, is fine, and will net you with a new room to fight");
        System.out.println("\nInput Anything, then Press enter to continue");
        playerInput.nextLine();

        while (getPlayer().getHealth() > 0 && !bossDefeated)
        {
            //Choose a direction
            try {
                System.out.println("\nChoose a direction, 1 for turn left, 2 for forward, 3 for turn right");
                playerNumberInput = playerInput.nextInt();
                if(playerNumberInput == 1)
                {previousDirection = Direction.LEFT;
                positionsToLeft++;}
                else if(playerNumberInput == 2)
                {previousDirection = Direction.FORWARD;}
                else if(playerNumberInput == 3)
                {previousDirection = Direction.RIGHT;
                positionsToLeft--;}
                else {
                    System.out.println("\nWith your head in the clouds, you choose to got the same direction as before\n");
                    if(previousDirection == Direction.LEFT){
                        positionsToLeft++;
                    }
                    else if(previousDirection == Direction.RIGHT){
                        positionsToLeft--;
                    }
                }
            }
            catch (InputMismatchException e) {
                playerNumberInput = 0;
                System.out.println("\nWith your head in the clouds, you choose to got the same direction as before\n");
                if(previousDirection == Direction.LEFT){
                    positionsToLeft++;
                }
                else if(previousDirection == Direction.RIGHT){
                    positionsToLeft--;
                }
            }
            //Begin the fight, generate the enemies
            if(positionsToLeft == 10)
            {
                enemy1 = enemyFactory.getEnemy("primalMonster");
                enemy1Title = "King Goblin";
            }
            else
            {
                randInt = theRandom.nextInt(3);
                if (randInt == 0)
                {
                    enemy1 = enemyFactory.getEnemy("goblin");
                    enemy1Title = "goblin";
                }
                else if (randInt == 1)
                {
                    enemy1 = enemyFactory.getEnemy("zombie");
                    enemy1Title = "zombie";
                }
                else if (randInt == 2)
                {
                    enemy1 = enemyFactory.getEnemy("decayed");
                    enemy1Title = "decayed";
                }
                else
                {
                    enemy1 = enemyFactory.getEnemy("primalMonster");
                    enemy1Title = "King Goblin";
                }
            }

            //Fight the battle
            //while () {
                try {

                }
                catch (InputMismatchException e) {
                    playerNumberInput = 0;
                }
            //}
            //Display item drops, Choose weather or not to keep an item
            try {
                if (previousDirection == Direction.RIGHT){

                }
            }
            catch (InputMismatchException e) {
                playerNumberInput = 0;
                System.out.println("Fumbling the object, you loose hold of it entirely and can't find it again, too bad!");
            }
            //Apply level up if available
            if (previousDirection == Direction.FORWARD || previousDirection == Direction.LEFT)
            {

            }

            break;
        }

        if (getPlayer().getHealth() <= 0) {
            System.out.println("GAME OVER!");
        }
        else if (bossDefeated) {
            System.out.println("CONGRATULATIONS! YOU WIN!");
        }
        else{
            System.out.println("Incredible work, you managed to get out of the game's while loop without loosing all your health, \n" +
                    "  or defeating the final boss, how in the world could you have even done that?");
        }
    }

    //gets the player instance
    private Player getPlayer(){
        return Player.getInstance();
    }

    //Space for all game states or player input variables to be get or set, just in case of special circumstances
    public int getPlayerNumberInput() {
        return playerNumberInput;
    }
    public void setPlayerNumberInput(int playerNumberInput) {
        this.playerNumberInput = playerNumberInput;
    }

    public boolean isBossDefeated() {
        return bossDefeated;
    }
    public void setBossDefeated(boolean bossDefeated) {
        this.bossDefeated = bossDefeated;
    }

    public int getPositionsToLeft() {
        return positionsToLeft;
    }
    public void setPositionsToLeft(int positionsToLeft) {
        this.positionsToLeft = positionsToLeft;
    }

    public int getStage() {
        return stage;
    }
    public void setStage(int stage) {
        this.stage = stage;
    }
    public void incrementStage(){
        stage++;
    }

    public Direction getPreviousDirection() {
        return previousDirection;
    }
    public void setPreviousDirection(Direction previousDirection) {
        this.previousDirection = previousDirection;
    }
}
