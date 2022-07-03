package humansvgoblins.game.utils;

public enum Tile {

    DOOR('░' ),
    GOBLIN('☠'),
    GOLD('₿'),
    HP_POTION('♥'),
    HUMAN('☃'),
    KEY('❃'),
    NOTHING('_'),
    STAIRS('△'),
    TRAP('☢'),
    TREASURE('★'),
    WALL('卌');

    private char symbol;

    Tile(char symbol) {
        this.symbol = symbol;
    }

    public char symbol() {
        return symbol;
    }
}
