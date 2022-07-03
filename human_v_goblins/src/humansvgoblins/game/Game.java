package humansvgoblins.game;


import java.util.ArrayList;

import javax.swing.JFrame;

import humansvgoblins.game.elements.Floor;
import humansvgoblins.game.elements.Goblin;
import humansvgoblins.game.elements.Human;

import humansvgoblins.game.gui.GameBoard;

import humansvgoblins.game.utils.Functions;

public class Game {

    private static JFrame window;
    private static GameBoard gameBoard;

    public static void main(String[] args) {

        System.out.println("[Game]: Loading...");
        createWindow();
        createGameBoard();
        initGame();
        //askForHumanName();
    }

    private static void createWindow() {
        System.out.println("[Game]: Creating window");
        window = new JFrame("Humans vs Goblins");
        window.setVisible(true);
        window.setResizable(false);
        window.setBounds(200, 80, Reference.windowWidth, Reference.windowHeight);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void createGameBoard() {
        System.out.println("[Game]: Creating GameBoard");
        gameBoard = new GameBoard();
        window.add(gameBoard);
        gameBoard.requestFocusInWindow();
    }

    /**Starts a new game!*/
    public static void initGame() {
        //initialization
        Reference.currentFloor = new Floor(0);
        Reference.human = new Human(3, 2);
        Reference.goblins = new ArrayList<Goblin>();

        Functions.initMovingTiles();
    }
}
