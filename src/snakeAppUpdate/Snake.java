package snakeAppUpdate;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import static snakeAppUpdate.MainGameSnake.*;


public class Snake {
    List<Point> snake = new ArrayList<Point>();
    int direction;
    private boolean isFailed = false;

    public Snake(int x, int y, int length, int direction) {
        for (int i = 0; i < length; i++) {
            Point point = new Point(x - i, y);
            snake.add(point);
        }
        this.direction = direction;
    }

    public void go(List<IObstacle> obstacles) {
        if (obstacles.size() == 0) {
            IObstacle food = new Food();
            IObstacle poison = new Poison();
            obstacles.add(food);
            obstacles.add(poison);
//            System.out.print("Init: ");
//            printArray(obstacles);
        }

        int x = snake.get(0).getX();
        int y = snake.get(0).getY();
        switch (direction) {
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            default:
                break;
        }
        if (x > FIELD_WEIGHT) x = 0;
        if (x < 0) x = FIELD_WEIGHT - 1;
        if (y > FIELD_HEIGHT - 1) y = 0;
        if (y < 0) y = FIELD_HEIGHT - 1;

        isFailed = isInsideSnake(x, y);
        if (isFailed) {
            System.out.println("EAT!!!");
        }

        snake.add(0, new Point(x, y));
        int eatCounter = 0;
        for (IObstacle obstacle : obstacles) {
            if (isNoEmptyObstacle(obstacle)) {
//                System.out.println("Клетка занята");
                if (obstacle.getType().equals("poison")) {
//                    System.out.println("Занята ядом");
                    isFailed = obstacle.tryEat();
                } else {
//                    System.out.println("Занята едой");
                    obstacle.tryEat();
                    eatCounter++;
                }
            }
        }
        if (eatCounter > 0) {
//            System.out.println("Клетка занята едой");
        } else {
//            System.out.println("Клетка свободна");
            snake.remove(snake.size() - 1);
        }
        addNewObstacle(obstacles);
    }

    private void addNewObstacle(List<IObstacle> obstacles) {
        if (snake.size() == 8 && obstacles.size() < 3) {
            obstacles.add(new Food());
        }
        if (snake.size() == 12 && obstacles.size() < 4) {
            obstacles.add(new Poison());
        }
        if (snake.size() == 15 && obstacles.size() < 5) {
            obstacles.add(new Food());
        }

    }

    private void printArray(List<IObstacle> obstacles) {
        for (IObstacle obstacle : obstacles) {
            System.out.print(obstacle + "; ");
        }
        System.out.println();
    }

    public boolean isFailed() {
        return isFailed;
    }

    private boolean isNoEmptyObstacle(IObstacle obstacle) {
        return (snake.get(0).getX() == obstacle.getX() &&
                snake.get(0).getY() == obstacle.getY()
        );
    }

    protected boolean isInsideSnake(int x, int y) {
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
