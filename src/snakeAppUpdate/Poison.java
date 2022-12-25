package snakeAppUpdate;

import java.awt.Graphics;
import java.util.List;

import static snakeAppUpdate.MainGameSnake.FIELD_HEIGHT;
import static snakeAppUpdate.MainGameSnake.FIELD_WEIGHT;
import static snakeAppUpdate.MainGameSnake.POINT_RADIUS;
import static snakeAppUpdate.MainGameSnake.POISON_COLOR;
import static snakeAppUpdate.MainGameSnake.random;

public class Poison extends Point implements IObstacle {
    private final String type;
    private boolean isEaten = false;
    private int counter = 0;

    public Poison() {
        super(-1, -1);
        this.type = "poison";
        setColor(POISON_COLOR);
    }

    public void init(Snake snake) {
        if (counter == 0) {
            System.out.println("Poison init");
            int x, y;
            do {
                x = random.nextInt(FIELD_WEIGHT);
                y = random.nextInt(FIELD_HEIGHT - 1);
            } while (snake.isInsideSnake(x, y));
            counter++;
            setXY(x, y);
        }
    }

    @Override
    public void relocate(Snake snake, List<IObstacle> list) {
        return;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(super.getColor());
        g.fillOval(getX() * POINT_RADIUS, getY() * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
    }

    @Override
    public boolean isObstacleCoordinate(int x, int y) {
        return (x == this.getX() && y == this.getY());
    }

    public boolean tryEat(){
        System.out.println("Poison try Eat");
        return  isEaten = true;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean isEaten() {
        return isEaten;
    }

    @Override
    public String toString() {
        return "{" + type + " " +
                "x: " + getX() +
                ", y: " + getY() + " " +
                '}';
    }
}
