package snakeAppUpdate;

import java.awt.Graphics;
import java.util.List;

import static snakeAppUpdate.MainGameSnake.FIELD_HEIGHT;
import static snakeAppUpdate.MainGameSnake.FIELD_WEIGHT;
import static snakeAppUpdate.MainGameSnake.FOOD_COLOR;
import static snakeAppUpdate.MainGameSnake.POINT_RADIUS;
import static snakeAppUpdate.MainGameSnake.random;

public class FoodUpdate extends Point implements IObstacle {
    String type;

    public FoodUpdate() {
        super(-1, -1);
//        super(10, 10);
        type = "food";
        setColor(FOOD_COLOR);
    }

    public void eat() {
        setXY(-2, -2);
    }
    @Override
    public boolean tryEat(){
        setXY(-1, -1);
        return true;
    }

    @Override
    public void init(SnakeUpdate snake) {
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

    public void relocate(SnakeUpdate snake, List<IObstacle> obstacles){
        for (IObstacle obstacle : obstacles){
            if (obstacle.getType().equals("poison")){
                obstacle.init(snake);
            }
        }
        int x, y;
        do {
            x = random.nextInt(FIELD_WEIGHT);
            y = random.nextInt(FIELD_HEIGHT -1);
        } while (snake.isInsideSnake(x, y));
        setXY(x, y);

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(super.getColor());
        g.fillOval(getX() * POINT_RADIUS, getY() * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
    }

    @Override
    public String toString() {
        return "{" + type + " " +
                "x: " + getX() +
                ", y: " + getY() + " " +
                '}';
    }
}
