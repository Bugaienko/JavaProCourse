//package snakeAppUpdate;
//
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.awt.geom.Line2D;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
///**
// * Classic Game Snake
// * written on December 2022
// */
//public class MainGameSnake extends JFrame {
//
//    final String TITLE_OF_PROGRAM = "Classic Game Snake";
//    final String GAME_OVER_MSG = "GAME OVER!!!";
//    final static int POINT_RADIUS = 20;
//    final static int FIELD_WEIGHT = 30;
//    final static int FIELD_HEIGHT = 20;
//    final static int FIELD_DX = 6;
//    final static int FIELD_DY = 8;
//    final static int START_LOCATION = 200;
//    final static int START_SNAKE_SIZE = 6;
//    final static int START_SNAKE_X = 10;
//    final static int START_SNAKE_Y = 10;
//    final static int SHOW_DELAY = 150;
//    final static int LEFT = 37;
//    final static int UP = 38;
//    final static int RIGHT = 39;
//    final static int DOWN = 40;
//    final static int START_DIRECTION = RIGHT;
//    final static Color DEFAULT_COLOR = Color.BLUE;
//    final static Color FOOD_COLOR = Color.green;
//    final static Color POISON_COLOR = Color.red;
//
//
//    private Snake snake;
//    private List<IObstacle> obstacles;
//
//    JFrame frame, frameBg;
//    Canvas canvasPanel;
//    CanvasBg canvasPanelBg;
//    static Random random = new Random();
//    Boolean isGameOver = false;
//
//    public MainGameSnake() {
//        super();
//        CanvasBg n1 = new CanvasBg();
//        setLayout(new BorderLayout());
//        add(n1, BorderLayout.CENTER);
//        System.out.println("CONSTR");
//        setVisible(true);
//    }
//
//    public void paint(Graphics g){
//        System.out.println("Paint MAIN");
//
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setSize(FIELD_WEIGHT * POINT_RADIUS + FIELD_DX,
//                FIELD_HEIGHT * POINT_RADIUS + FIELD_DY);
//        setLocation(START_LOCATION, START_LOCATION);
//        setResizable(false);
//        setLayout(new BorderLayout());
//
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setColor(new Color(255, 255, 255, 32));
//        g2d.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND,
//                BasicStroke.JOIN_BEVEL));
//        for (int i = 0; i < FIELD_WEIGHT * POINT_RADIUS; i += POINT_RADIUS) {
//            Line2D line = new Line2D.Double(i, 5, i, FIELD_HEIGHT * POINT_RADIUS - 25);
//            g2d.draw(line);
//        }
//        for (int i = 0; i < FIELD_HEIGHT * POINT_RADIUS; i += POINT_RADIUS) {
//            Line2D line = new Line2D.Double(5, i, FIELD_WEIGHT * POINT_RADIUS - 5, i);
//            g2d.draw(line);
//        }
//    }
//
//    public static void main(String[] args) {
////        new MainGameSnake().setVisible(true);
//        new MainGameSnake().go();
//    }
//
//    void go() {
//        frame = new JFrame(TITLE_OF_PROGRAM + " : " + START_SNAKE_SIZE);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setSize(FIELD_WEIGHT * POINT_RADIUS + FIELD_DX,
//                FIELD_HEIGHT * POINT_RADIUS + FIELD_DY);
//        frame.setLocation(START_LOCATION, START_LOCATION);
//        frame.setResizable(false);
//        frame.setLayout(new BorderLayout());
//
//        canvasPanel = new Canvas();
////        canvasPanel.setBackground(Color.lightGray);
//
//
////        canvasPanelBg = new CanvasBg();
////        canvasPanelBg.setBackground(Color.ORANGE);
////        CanvasBg nett = new CanvasBg();
////        nett.setSize(new Dimension(500, 400));
////        System.out.println(nett.getSize());
////        canvasPanel.add(nett);
////        frame.add(nett, BorderLayout.CENTER);
//
////        canvasPanel.setPreferredSize(new Dimension(600, 300));
////        canvasPanel.setBackground(new Color(128,128,128));
////        System.out.println(canvasPanel.getSize());
//
//
////        canvasPanelBg.add(canvasPanel, BorderLayout.CENTER);
////            canvasPanel.add(canvasPanelBg);
//
//        frame.add(canvasPanel, BorderLayout.CENTER);
////        frame.add(canvasPanelBg, BorderLayout.CENTER);
//
//
//
//        frame.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                super.keyPressed(e);
//                snake.setDirection(e.getKeyCode());
//            }
//        });
//
//
//
//
//        frame.setVisible(true);
//
//        System.out.println(canvasPanel.getLocation() + " " + canvasPanel.getSize());
////        System.out.println(canvasPanelBg.getLocation() + " " + canvasPanelBg.getSize());
//
//        snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, START_DIRECTION);
//        obstacles = new ArrayList<>();
//        while (!isGameOver) {
//            snake.go(obstacles);
//            if (moveEaten()) {
//                frame.setTitle(TITLE_OF_PROGRAM + " : " + snake.getSize());
//            }
//            isGameOver = snake.isFailed();
//            canvasPanel.repaint();
//            try {
//                Thread.sleep(SHOW_DELAY);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//    }
//
//    public class Canvas extends JPanel {
//        @Override
//        public void paint(Graphics g) {
//            Graphics2D g2d = (Graphics2D) g;
//            super.paint(g2d);
//
////            drawNett(g);
//            snake.paint(g);
//            for (IObstacle obstacle : obstacles) {
//                obstacle.paint(g);
//            }
//            if (isGameOver) {
//                g2d.setColor(Color.red);
//                g2d.setFont(new Font("Arial", Font.BOLD, 40));
//                FontMetrics fm = g2d.getFontMetrics();
//                g2d.drawString(GAME_OVER_MSG, (FIELD_WEIGHT * POINT_RADIUS + FIELD_DX - fm.stringWidth(GAME_OVER_MSG)) / 2,
//                        (FIELD_HEIGHT * POINT_RADIUS + FIELD_DY) / 2);
//            }
//        }
//
//    }
//
//    public class CanvasBg extends Component {
//        @Override
//        public void paint(Graphics g) {
////            System.out.println("Я рисую nett");
//            Graphics2D g2d = (Graphics2D) g;
//            super.paint(g2d);
//            g2d.setColor(new Color(255, 255, 255, 128));
//            g2d.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND,
//                    BasicStroke.JOIN_BEVEL));
//            for (int i = 0; i < FIELD_WEIGHT * POINT_RADIUS; i += POINT_RADIUS) {
//                Line2D line = new Line2D.Double(i, 5, i, FIELD_HEIGHT * POINT_RADIUS - 25);
//                g2d.draw(line);
//            }
//            for (int i = 0; i < FIELD_HEIGHT * POINT_RADIUS; i += POINT_RADIUS) {
//                Line2D line = new Line2D.Double(5, i, FIELD_WEIGHT * POINT_RADIUS - 5, i);
//                g2d.draw(line);
//            }
//        }
//    }
//
//    private void drawNett(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setColor(new Color(255, 255, 255, 32));
//        g2d.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND,
//                BasicStroke.JOIN_BEVEL));
//        for (int i = 0; i < FIELD_WEIGHT * POINT_RADIUS; i += POINT_RADIUS) {
//            Line2D line = new Line2D.Double(i, 5, i, FIELD_HEIGHT * POINT_RADIUS - 25);
//            g2d.draw(line);
//        }
//        for (int i = 0; i < FIELD_HEIGHT * POINT_RADIUS; i += POINT_RADIUS) {
//            Line2D line = new Line2D.Double(5, i, FIELD_WEIGHT * POINT_RADIUS - 5, i);
//            g2d.draw(line);
//        }
//
//    }
//
//    private boolean moveEaten() {
//        boolean result = false;
//        for (IObstacle obstacle : obstacles) {
//            if (obstacle.getType().equals("food") && obstacle.isEaten()) {
////                System.out.println("Еда съедена. Надо передвигать");
//                obstacle.relocate(snake, obstacles);
//                result = true;
//            }
//        }
//        return result;
//    }
//}
