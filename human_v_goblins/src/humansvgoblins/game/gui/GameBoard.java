package humansvgoblins.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import humansvgoblins.game.Game;
import humansvgoblins.game.Reference;
import humansvgoblins.game.utils.Direction;
import humansvgoblins.game.utils.Functions;

public class GameBoard extends JPanel implements KeyListener {

    public GameBoard() {
        addKeyListener(this);
        this.setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint(); revalidate();

        //Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Reference.windowWidth, Reference.windowHeight);
        g.setColor(Color.WHITE);
        g.drawRoundRect(5, 5, Reference.windowWidth-220, Reference.windowHeight-150, 5, 5);
        g.drawRoundRect(790, 5, Reference.windowWidth-800, Reference.windowHeight-150, 5, 5);
        g.drawRoundRect(5, Reference.windowHeight-140, Reference.windowWidth-15, Reference.windowHeight-500, 5, 5);

        //Floor
        g.setColor(Color.WHITE);

        int x, y;
        if(Reference.currentFloor.isFirstFloor()) {x=200; y=100;}
        else {x=15; y=20;}

        for(int i=0;i<Reference.currentFloor.getHeight();i++) {
            for(int j=0;j<Reference.currentFloor.getWidth();j++) {
                g.drawString(""+Reference.currentFloor.getTileChar(j, i), x, y);
                x+=10;
            }
            //y+=15; x=15;
            if(Reference.currentFloor.isFirstFloor()) {x=200; y+=15;}
            else {x=15; y+=15;}
        }

        //Player stats
        g.setFont(new Font("arial", Font.PLAIN, 30));
        g.drawString("Human", 800, 50);
        g.setFont(new Font("arial", Font.PLAIN, 15));
        g.drawString("HP: "+Reference.human.getHP()+"/"+Reference.human.getMaxHP(), 800, 75);
        g.drawString("STR: "+Reference.human.getStr(), 800, 95);
        g.drawString("DEF: "+Reference.human.getDef(), 800, 115);
        g.drawString("Gold: "+Reference.human.getGold(), 800, 140);
        g.drawString("Keys: "+Reference.human.getKeys(), 800, 160);
        g.drawString("Weapon Equipped:", 800, 185);
        g.drawString(Reference.human.getWeapon().getName(), 810, 205);
        g.drawString("Armor Equipped:", 800, 230);
        g.drawString(Reference.human.getArmor().getName(), 810, 250);

        //Message
        g.drawString(Functions.getMessage(), 15, 480);
        g.drawString(Functions.getMessage2(), 15, 500);
        g.drawString(Functions.getMessage3(), 15, 520);

        //Title
        if(Reference.currentFloor.isFirstFloor()) {
            g.setFont(new Font("arial", Font.PLAIN, 40));
            g.drawString("Humans vs Goblins", 200, 70);
            g.setFont(new Font("arial", Font.PLAIN, 15));
            g.drawString("Use WASD or arrow keys to move", 300, 150);
            g.drawString("Walk towards the stairs to start", 300, 170);
            g.drawString(Functions.getMessage(), 300, 190);

        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        if(Reference.human.isAlive()) {
            switch(arg0.getKeyCode()) {
                //Move player north
                case KeyEvent.VK_W:
                case KeyEvent.VK_UP:
                    Reference.human.setFacing(Direction.NORTH);
                    Functions.handleHumanMovement(Direction.NORTH);
                    Reference.currentFloor.updateHumanPos();
                    Functions.moveGoblins();
                    Reference.currentFloor.updateGoblinsPos();
                    break;
                //Move player west
                case KeyEvent.VK_A:
                case KeyEvent.VK_LEFT:
                    Reference.human.setFacing(Direction.WEST);
                    Functions.handleHumanMovement(Direction.WEST);
                    Reference.currentFloor.updateHumanPos();
                    Functions.moveGoblins();
                    Reference.currentFloor.updateGoblinsPos();
                    break;
                //Move player south
                case KeyEvent.VK_S:
                case KeyEvent.VK_DOWN:
                    Reference.human.setFacing(Direction.SOUTH);
                    Functions.handleHumanMovement(Direction.SOUTH);
                    Reference.currentFloor.updateHumanPos();
                    Functions.moveGoblins();
                    Reference.currentFloor.updateGoblinsPos();
                    break;
                //Move player right
                case KeyEvent.VK_D:
                case KeyEvent.VK_RIGHT:
                    Reference.human.setFacing(Direction.EAST);
                    Functions.handleHumanMovement(Direction.EAST);
                    Reference.currentFloor.updateHumanPos();
                    Functions.moveGoblins();
                    Reference.currentFloor.updateGoblinsPos();
                    break;
                //Make decision Yes
                case KeyEvent.VK_Y:
                    Functions.makeDecision(true);
                    Reference.currentFloor.updateHumanPos();
                    break;
                //Make decision No
                case KeyEvent.VK_N:
                    Functions.makeDecision(false);
                    Reference.currentFloor.updateHumanPos();
                    break;
            }
            Functions.checkHumanDeath();
        }
        else {
            Game.initGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {}

    @Override
    public void keyTyped(KeyEvent arg0) {}

}
