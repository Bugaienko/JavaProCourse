package snapeApp;

import static snapeApp.GameSnake.*;
import static snapeApp.GameSnake.getSnake;

public class FoodUpdate extends Point implements IObstacle{
    String type;

    public FoodUpdate() {
        super(-1, -1);
        type = "food";
        setColor(FOOD_COLOR);
    }

    public void eat() {
        setXY(-2, -2);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean isEaten() {
        return this.getX() < 0;
    }

    void next(SnakeUpdate snake, Poison poison) {
        poison.init(snake);
        int x, y;
        do {
            x = random.nextInt(FIELD_WEIGHT);
            y = random.nextInt(FIELD_HEIGHT -1);
        } while (snake.isInsideSnake(x, y) && (poison.getX() != x && poison.getY() != y));
        setXY(x, y);
    }
}
