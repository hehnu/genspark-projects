package humansvgoblins.game.utils;

import java.util.Random;

import humansvgoblins.game.Reference;
import humansvgoblins.game.elements.Armor;
import humansvgoblins.game.elements.Floor;
import humansvgoblins.game.elements.Goblin;
import humansvgoblins.game.elements.Weapon;

//import static humansvgoblins.game.utils.Tile.GOBLIN;
//import static humansvgoblins.game.utils.Tile.HUMAN;

public class Functions {

    /**Initializes all moving tiles in the floor like player etc.*/
    public static void initMovingTiles() {

        Reference.goblins.clear();

        for(int y=0;y<Reference.currentFloor.getHeight()-1;y++) {
            for(int x=0;x<Reference.currentFloor.getWidth()-1;x++) {
                switch(Reference.currentFloor.getTile(x, y)) {
                    case HUMAN:
                        Reference.human.setPos(x, y);
                        break;
                    case GOBLIN:
                        Reference.goblins.add(new Goblin("Goblin", x, y, 10, 2, 2));
                    default:
                        break;
                }
            }
        }
    }

    /**Returns a random number between 1 and n
     * @param n - The upper bound (inclusive)
     * @return a random number between 1 and n*/
    public static int getRandomNumber(int n) {
        Random rand = new Random();
        return rand.nextInt(n)+1;
    }

    /**Checks if player can move and calls Reference.player.move(Direction)
     * @param direction - The direction the player wants to move*/
    public static void handleHumanMovement(Direction direction) {
        //Gets the tile the player is trying to move on
        Tile tile = null;
        switch(direction) {
            case NORTH:
                tile = Reference.currentFloor.getTile(Reference.human.getX(), Reference.human.getY()-1);break;
            case WEST:
                tile = Reference.currentFloor.getTile(Reference.human.getX()-1, Reference.human.getY()); break;
            case SOUTH:
                tile = Reference.currentFloor.getTile(Reference.human.getX(), Reference.human.getY()+1); break;
            case EAST:
                tile = Reference.currentFloor.getTile(Reference.human.getX()+1, Reference.human.getY()); break;
        }

        //Handles the player movement
        switch(tile){
            case NOTHING:
                Reference.human.move(direction);
                message = " ";
                message2 = " ";
                message3 = " ";
                break; //Move the player if it is in front of one of these tiles
            case WALL:
                message = "You ran into a wall!";
                message2 = " ";
                message3 = " ";
                break;
            case STAIRS:
                Reference.human.move(direction);
                Reference.currentFloor = new Floor(Functions.getRandomNumber(Reference.floorCount));
                message = "You went into a new floor!";
                message2 = " ";
                message3 = " ";
                floorsCleared++;
                Functions.initMovingTiles();
                break; //Randomly change floor
            case TRAP:
                Reference.human.move(direction);
                Reference.human.damage(Functions.getRandomNumber(2));
                message = "You ran into a trap and you took damage!";
                message2 = " ";
                message3 = " ";
                break; //Damage the player of 1 or 2 points
            case HP_POTION:
                message = "You found an health potion! Do you want to drink it?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decision = HumanDecision.DRINK_HP_POTION;
                break; //Ask the player if it want to drink the potion
            case GOLD:
                Reference.human.move(direction);
                Reference.human.addGold(Functions.getRandomNumber(3)+2);
                message = "You picked up gold!";
                message2 = " ";
                message3 = " ";
                break; //Add between 3 and 5 gold
            case TREASURE:
                message = "You found a treasure chest! Do you want to open it for 10 gold?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decision = HumanDecision.OPEN_CHEST;
                break; //Ask to open chest
            case KEY:
                Reference.human.move(direction);
                Reference.human.addKey();
                message = "You picked up a small key! What will its use be?";
                message2 = " ";
                message3 = " ";
                break; //Adds a key
            case DOOR:
                message = "This door is locked... Do you want to use a key to open it?";
                message2 = "   [Y] Yes     [N] No";
                message3 = " ";
                decision = HumanDecision.OPEN_DOOR;
                break; //Ask to open door
            case GOBLIN:
                message = "You encountered a goblin!";
                message2 = " ";
                message3 = " ";
                Functions.goblinEncounter(direction);
                break; //Handles encounters with goblins
            default:
                message = "Something strange happened...";
                message2 = " ";
                message3 = " ";
                break; //If something glitches out
        }
    }

    /**Called when the player has to make a decision
     * @param yn - True for yes, false for no*/
    public static void makeDecision(boolean yn) {
        if(decision == HumanDecision.NONE) {
            return; //Nothing
        }
        else if(decision == HumanDecision.DRINK_HP_POTION && yn == true) {
            Reference.human.heal(Functions.getRandomNumber(5)+3);
            message = "You drank the potion and recovered health!";
            message2 = " ";
            message3 = " ";
            Reference.human.move(); //Drink potion
        }
        else if(decision == HumanDecision.DRINK_HP_POTION && yn == false) {
            message = "I don't need it right now...";
            message2 = " ";
            message3 = " "; //Doesn't drink potion
        }
        else if(decision == HumanDecision.OPEN_CHEST && yn == true) {
            if(Reference.human.getGold()>=10) {
                Reference.human.takeGold(10);
                message = "You opened the chest!";
                message2 = " ";
                message3 = " "; //Open chest

                //Chose weapon or armor
                if(Functions.getRandomNumber(2) == 1) {
                    Reference.human.equipWeapon(Weapon.getRandomWeapon());
                    message2 = Reference.human.getWeapon().getName()+" equipped!";
                }
                else {
                    Reference.human.equipArmor(Armor.getRandomArmor());
                    message2 = Reference.human.getArmor().getName()+" equipped!";
                }

                Reference.human.move();

            }
            else {
                message = "You don't have enough gold...";
                message2 = " ";
                message3 = " ";
            }
        }
        else if(decision == HumanDecision.OPEN_CHEST && yn == false) {
            message = "I don't want to open it...";
            message2 = " ";
            message3 = " "; //Doesn't open chest
        }
        else if(decision == HumanDecision.OPEN_DOOR && yn == true) {
            if(Reference.human.getKeys()>0) {
                Reference.human.takeKey();
                Reference.human.move();
                message = "You opened the door!";
                message2 = " ";
                message3 = " "; //Open door
            }
            else {
                message = "You don't have a key...";
                message2 = " ";
                message3 = " ";
            }
        }
        else if(decision == HumanDecision.OPEN_DOOR && yn == false) {
            message = "Maybe it's not a good idea... Who wonders what's behind.";
            message2 = " ";
            message3 = " "; //Doesn't open door
        }

        decision = HumanDecision.NONE;
    }

    /**Moves all the monsters on the floor*/
    public static void moveGoblins() {
        for(int i=0;i<Reference.goblins.size();i++) {
            Reference.goblins.get(i).moveRandom();
        }
    }

    /**Makes a monster attack the player and the player attack the monster
     * @param direction - The position of the monster relative to the player*/
    public static void goblinEncounter(Direction direction) {
        int goblinX=0, goblinY=0;

        switch(direction) {
            case NORTH:
                goblinX = Reference.human.getX(); goblinY = Reference.human.getY()-1; break;
            case WEST:
                goblinX = Reference.human.getX()-1; goblinY = Reference.human.getY(); break;
            case SOUTH:
                goblinX = Reference.human.getX(); goblinY = Reference.human.getY()+1; break;
            case EAST:
               goblinX = Reference.human.getX()+1; goblinY = Reference.human.getY(); break;
        }

        for(int i=0;i<Reference.goblins.size();i++) {
            if(Reference.goblins.get(i).getX() == goblinX && Reference.goblins.get(i).getY() == goblinY) {
                float humanAttack = Reference.human.getStr()-(Reference.goblins.get(i).getDef()/10)*Reference.human.getStr();
                float goblinAttack = Reference.goblins.get(i).getStr()-(Reference.human.getDef()/10)*Reference.goblins.get(i).getStr();
                Reference.goblins.get(i).damage(humanAttack);
                Reference.human.damage(goblinAttack);
                message2 = "You attacked the goblin and left him with "+Reference.goblins.get(i).getHP()+" HP!";
                message3 = "The goblin attacked you!";
            }
        }
    }

    /**Displays a death message if the player has 0 hp*/
    public static void checkHumanDeath() {
        if(Reference.human.getHP()<=0) {
            message = "You died!";
            message2 = "You cleared "+floorsCleared+" floors!";
            message3 = "Press any button to continue";
            Reference.human.setDead();
        }
    }

    private static String message = " ";
    private static String message2 = " ";
    private static String message3 = " ";
    private static int floorsCleared = 0;
    /**Returns the message to display on the screen*/
    public static String getMessage() {return message;}
    /**Returns the second message to display on the screen*/
    public static String getMessage2() {return message2;}
    /**Returns the third message to display on the screen*/
    public static String getMessage3() {return message3;}

    private static HumanDecision decision = HumanDecision.NONE;
    private enum HumanDecision {
        NONE,
        DRINK_HP_POTION,
        OPEN_CHEST,
        OPEN_DOOR;
    }
}
