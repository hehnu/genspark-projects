package humansvgoblins.game.elements;

//import humansvgoblins.game.elements.Character;
import humansvgoblins.game.Reference;
import humansvgoblins.game.utils.Direction;
import humansvgoblins.game.utils.Functions;
import humansvgoblins.game.utils.Tile;

public class Goblin extends Character {

    private String name;

    /**Creates a monster
     * @param name - Name
     * @param posX - Position on the x coordinate
     * @param posY - Position on the y coordinate
     * @param health - Hp and MaxHp
     * @param strength - Attack base value
     * @param defence - Defence base value*/
    public Goblin(String name, int posX, int posY, int health, int strength, int defence) {
        super(posX, posY, health, strength, defence);
        this.name=name;
        System.out.println("[Goblin]: Creating goblin");
    }

    /**Moves the monster in a random direction*/
    public void moveRandom() {
        switch(Functions.getRandomNumber(4)) {
            case 1:
                if(Reference.currentFloor.getTile(this.getX(), this.getY()-1) == Tile.NOTHING)
                    super.move(Direction.NORTH);
                else if(Reference.currentFloor.getTile(this.getX(), this.getY()-1) == Tile.HUMAN)
                    Functions.goblinEncounter(Direction.NORTH);
                break;
            case 2:
                if(Reference.currentFloor.getTile(this.getX()-1, this.getY()) == Tile.NOTHING)
                    super.move(Direction.WEST);
                else if(Reference.currentFloor.getTile(this.getX()-1, this.getY()) == Tile.HUMAN)
                    Functions.goblinEncounter(Direction.WEST);
                break;
            case 3:
                if(Reference.currentFloor.getTile(this.getX(), this.getY()+1) == Tile.NOTHING)
                    super.move(Direction.SOUTH);
                else if(Reference.currentFloor.getTile(this.getX(), this.getY()+1) == Tile.HUMAN)
                    Functions.goblinEncounter(Direction.SOUTH);
                break;
            case 4:
                if(Reference.currentFloor.getTile(this.getX()+1, this.getY()) == Tile.NOTHING)
                    super.move(Direction.EAST);
                else if(Reference.currentFloor.getTile(this.getX()+1, this.getY()) == Tile.HUMAN)
                    Functions.goblinEncounter(Direction.EAST);
                break;
        }
    }

    /**Getter Method*/
    public String getName() {return name;}

}
