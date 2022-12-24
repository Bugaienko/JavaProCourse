package snapeApp;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static snapeApp.GameSnake.*;

public class Snake {
    List<Point> snake = new ArrayList<Point>();
    int direction;

    public Snake(int x, int y, int length, int direction) {
        for (int i = 0; i < length; i++) {
            Point point = new Point(x - i, y);
            snake.add(point);
        }
        this.direction = direction;
    }

    public void move() {
        int x = snake.get(0).getX();
        int y = snake.get(0).getY();
        if (direction == LEFT) x--;
        if (direction == RIGHT) x++;
        if (direction == UP) y--;
        if (direction == DOWN) y++;

        if (x > FIELD_WEIGHT) x = 0;
        if (x < 0) x = FIELD_WEIGHT - 1;
        if (y > FIELD_HEIGHT - 1) y = 0;
        if (y < 0) y = FIELD_HEIGHT - 1;

        boolean isEatSelf = isInsideSnake(x, y);
        if (isEatSelf) {
            System.out.println("EAT!!!");
            setIsGameOver(isEatSelf);
        }
        snake.add(0, new Point(x, y));
        if (isNoEmpty(getFood())) {
            getFood().eat();
        } else {
            snake.remove(snake.size() - 1);
        }

    }

    boolean isNoEmpty(Point food) {
        return (snake.get(0).getX() == food.getX() &&
                snake.get(0).getY() == food.getY());
    }

    boolean isInsideSnake(int x, int y) {
        for (Point point : snake) {
            if (point.getX() == x && point.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public void setDirection(int direction) {
        if (direction <= DOWN && direction >= LEFT) {
            if (Math.abs(this.direction - direction) != 2) {
                this.direction = direction;
            }
        }
    }

    public void paint(Graphics g) {
        for (Point point : snake) {
            point.paint(g);
        }
    }

    public int getSize() {
        return snake.size();
    }
}
