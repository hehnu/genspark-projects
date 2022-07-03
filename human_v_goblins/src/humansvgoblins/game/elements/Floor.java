package humansvgoblins.game.elements;


import java.util.ArrayList;

import humansvgoblins.game.Reference;
import humansvgoblins.game.utils.Tile;
import humansvgoblins.game.utils.ResourceManager;

public class Floor {

    private ArrayList<ArrayList<Tile>> tiles;
    private boolean firstFloor;

    /**Creates a floor
     * @param floorNumber - The ordinal number of this floor in the file*/
    public Floor(int floorNumber) {
        System.out.println("[Floor]: Creating floor"+floorNumber);

        tiles = new ArrayList<ArrayList<Tile>>();

        ArrayList<String> strs = ResourceManager.readFloorFile("src/humansvgoblins/resources/floors/floor"+floorNumber+".txt");

        for(int i=0;i<strs.size()-1;i++) {
            char[] charArray = strs.get(i).toCharArray();
            tiles.add(new ArrayList<Tile>());
            for(int j=0;j<charArray.length;j++) {
                switch(charArray[j]) {
                    case '_':
                        tiles.get(i).add(Tile.NOTHING); break;
                    case '卌':
                        tiles.get(i).add(Tile.WALL); break;
                    case '☃':
                        tiles.get(i).add(Tile.HUMAN); break;
                    case '△':
                        tiles.get(i).add(Tile.STAIRS); break;
                    case '☢':
                        tiles.get(i).add(Tile.TRAP); break;
                    case '♥':
                        tiles.get(i).add(Tile.HP_POTION); break;
                    case '₿':
                        tiles.get(i).add(Tile.GOLD); break;
                    case '★':
                        tiles.get(i).add(Tile.TREASURE); break;
                    case '❃':
                        tiles.get(i).add(Tile.KEY); break;
                    case '░':
                        tiles.get(i).add(Tile.DOOR); break;
                    case '☠':
                        tiles.get(i).add(Tile.GOBLIN); break;
                }
            }
        }

        if(floorNumber == 0) firstFloor = true;
        else firstFloor = false;
    }

    /**Gets the size of the floor on the y coordinate*/
    public int getHeight() {
        return tiles.size();
    }

    /**Gets the size of the floor on the x coordinate*/
    public int getWidth() {
        return tiles.get(0).size();
    }

    /**Returns one tile of the floor
     * @param x - The x coordinate of the tile
     * @param y - The y coordinate of the tile*/
    public Tile getTile(int x, int y) {return tiles.get(y).get(x);}

    /**Returns one tile of the floor
     * @param x - The x coordinate of the tile
     * @param y - The y coordinate of the tile*/
    public char getTileChar(int x, int y) {return tiles.get(y).get(x).symbol();}

    /**Updates the position of the player*/
    public void updateHumanPos() {
        //Deletes old pos
        for(int i=0;i<this.getHeight();i++) {
            for(int j=0;j<this.getWidth();j++) {
                if(tiles.get(i).get(j) == Tile.HUMAN)
                    tiles.get(i).set(j, Tile.NOTHING);
            }
        }
        //Sets new pos
        tiles.get(Reference.human.getY()).set(Reference.human.getX(), Tile.HUMAN);
    }

    /**Updates the position of the goblinss*/
    public void updateGoblinsPos() {
        //Deletes old pos
        for(int i=0;i<this.getHeight();i++) {
            for(int j=0;j<this.getWidth();j++) {
                if(tiles.get(i).get(j) == Tile.GOBLIN)
                    tiles.get(i).set(j, Tile.NOTHING);
            }
        }
        //Sets new pos
        for(int i=0;i<Reference.goblins.size();i++) {
            if(Reference.goblins.get(i).getHP()<=0)
                Reference.goblins.remove(i);
            else
                tiles.get(Reference.goblins.get(i).getY()).set(Reference.goblins.get(i).getX(), Tile.GOBLIN);
        }

    }

    /**Getter Method
     * @return true if this is floor0 */
    public boolean isFirstFloor() {return firstFloor;}
}
