package snakeAppUpdate;

import java.awt.Graphics;
import java.util.List;

public interface IObstacle {
    String getType();
    boolean isEaten();
    int getX();
    int getY();

    boolean tryEat();
    void init(Snake snake);
    void relocate(Snake snake, List<IObstacle> list);
    void paint(Graphics g);

    boolean isObstacleCoordinate(int x, int y);
}
