package snakeAppUpdate;

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
            int x, y;
            do {
                x = random.nextInt(FIELD_WEIGHT);
                y = random.nextInt(FIELD_HEIGHT - 1);
            } while (snake.isInsideSnake(x, y));
            counter++;
            setXY(x, y);
        }
    }

    public void eat() {
        isEaten = true;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public boolean isEaten() {
        return isEaten;
    }
}
