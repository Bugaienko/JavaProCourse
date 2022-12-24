package snapeApp;

import static snapeApp.GameSnake.*;

public class Food extends Point {
    public Food() {
        super(-1, -1);
        setColor(FOOD_COLOR);
    }

    public void eat() {
        setXY(-2, -2);
    }

    boolean isEaten() {
        return this.getX() < 0;
    }

    void next() {
        int x, y;
        do {
            x = random.nextInt(FIELD_WEIGHT);
            y = random.nextInt(FIELD_HEIGHT -1);
        } while (getSnake().isInsideSnake(x, y));
        setXY(x, y);
        System.out.println(x + ":" + y);
    }
}
