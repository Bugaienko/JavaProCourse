package snakeAppUpdate;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.List;

import static snakeAppUpdate.MainGameSnake.FIELD_HEIGHT;
import static snakeAppUpdate.MainGameSnake.FIELD_WEIGHT;
import static snakeAppUpdate.MainGameSnake.FOOD_COLOR;
import static snakeAppUpdate.MainGameSnake.POINT_RADIUS;
import static snakeAppUpdate.MainGameSnake.random;

public class Food extends Point implements IObstacle {
    private final String type;

    public Food() {
        super(-1, -1);
//        super(10, 10);
        type = "food";
        setColor(FOOD_COLOR);
    }

    @Override
    public boolean tryEat(){
        setXY(-1, -1);
        return true;
    }

    @Override
    public void init(Snake snake, List<IObstacle> obstacles) {
        return;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean isEaten() {
        return this.getX() < 0;
    }

    public void relocate(Snake snake, List<IObstacle> obstacles){
        for (IObstacle obstacle : obstacles){
            if (obstacle.getType().equals("poison")){
                obstacle.init(snake, obstacles);
            }
        }
        int x, y;
        boolean isPoisonCell;
        do {
            x = random.nextInt(FIELD_WEIGHT);
            y = random.nextInt(FIELD_HEIGHT -1);
            isPoisonCell = false;
            for (IObstacle obstacle : obstacles) {
                    isPoisonCell = obstacle.isObstacleCoordinate(x, y);
            }
        } while (snake.isInsideSnake(x, y) || isPoisonCell);
        setXY(x, y);

    }

    @Override
    public boolean isObstacleCoordinate(int x, int y) {
        return (x == this.getX() && y == this.getY());
    }

    @Override
    public int getCounter() {
        return 0;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(super.getColor());
        Ellipse2D ellipse2D = new Ellipse2D.Double(getX() * POINT_RADIUS, getY() * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
        g2d.fill(ellipse2D);
//        g2d.fillOval(getX() * POINT_RADIUS, getY() * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
    }

    @Override
    public String toString() {
        return "{" + type + " " +
                "x: " + getX() +
                ", y: " + getY() + " " +
                '}';
    }
}
