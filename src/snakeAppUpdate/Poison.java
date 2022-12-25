package snakeAppUpdate;

import java.awt.*;
import java.util.List;

import static snakeAppUpdate.MainGameSnake.*;

public class Poison extends Point implements IObstacle {
    String type;
    boolean isEaten = false;
    int counter = 0;

    public Poison() {
        super(-1, -1);
        this.type = "poison";
        setColor(POISON_COLOR);
    }

    public void init(SnakeUpdate snake) {
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
    public void relocate(SnakeUpdate snake, List<IObstacle> list) {
        return;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(super.getColor());
        g.fillOval(getX() * POINT_RADIUS, getY() * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
    }

    public void eat() {
        System.out.println("Poison eat");
        isEaten = true;
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
