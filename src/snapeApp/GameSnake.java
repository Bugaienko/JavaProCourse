package snapeApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Classic Game Snake
 * written on December 2022
 */


public class GameSnake {
    final String TITLE_OF_PROGRAM = "Classic Game Snake";
    final String GAME_OVER_MSG = "GAME OVER!!!";
    final static int POINT_RADIUS = 20;
    final static int FIELD_WEIGHT = 30;
    final static int FIELD_HEIGHT = 20;
    final static int FIELD_DX = 6;
    final static int FIELD_DY = 8;
    final static int START_LOCATION = 200;
    final static int START_SNAKE_SIZE = 6;
    final static int START_SNAKE_X = 10;
    final static int START_SNAKE_Y = 10;
    final static int SHOW_DELAY = 150;
    final static int LEFT = 37;
    final static int UP = 38;
    final static int RIGHT = 39;
    final static int DOWN = 40;
    final static int START_DIRECTION = RIGHT;
    final static Color DEFAULT_COLOR = Color.BLUE;
    final static Color FOOD_COLOR = Color.green;
    final static Color POISON_COLOR = Color.red;


    private static Snake snake;
    private static Food food;
//    Poison poison;

    JFrame frame;
    Canvas canvasPanel;
    static Random random = new Random();
    static Boolean isGameOver = false;



    public static void main(String[] args) {
        new GameSnake().go();
    }

    void go() {
        frame = new JFrame(TITLE_OF_PROGRAM + " : " + START_SNAKE_SIZE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(FIELD_WEIGHT * POINT_RADIUS + FIELD_DX,
                FIELD_HEIGHT * POINT_RADIUS + FIELD_DY);
        frame.setLocation(START_LOCATION, START_LOCATION);
        frame.setResizable(false);
        canvasPanel = new Canvas();
        canvasPanel.setBackground(Color.lightGray);
        frame.add(canvasPanel, BorderLayout.CENTER);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                snake.setDirection(e.getKeyCode());
            }
        });


        frame.setVisible(true);

        snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, START_DIRECTION);
        food = new Food();
        while (!isGameOver){
            snake.move();
            if (food.isEaten()){
                food.next();
                frame.setTitle(TITLE_OF_PROGRAM + " : " + snake.getSize());
            }
            canvasPanel.repaint();
            try {
                Thread.sleep(SHOW_DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public class Canvas extends JPanel{
        @Override
        public void paint(Graphics g){
            super.paint(g);
            snake.paint(g);
            food.paint(g);
            if (isGameOver) {
                g.setColor(Color.red);
                g.setFont(new Font("Arial", Font.BOLD, 40));
                FontMetrics fm = g.getFontMetrics();
                g.drawString(GAME_OVER_MSG, (FIELD_WEIGHT * POINT_RADIUS + FIELD_DX - fm.stringWidth(GAME_OVER_MSG)) / 2,
                        (FIELD_HEIGHT * POINT_RADIUS + FIELD_DY) / 2);
            }
        }

    }

    public static Food getFood() {
        return food;
    }

    public static Snake getSnake() {
        return snake;
    }

    public static void setIsGameOver(Boolean isGameOver) {
        GameSnake.isGameOver = isGameOver;
    }
}
