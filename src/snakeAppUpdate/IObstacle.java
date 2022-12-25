package snakeAppUpdate;

import java.awt.Graphics;
import java.util.List;

public interface IObstacle {
    String getType();
    boolean isEaten();
    int getX();
    int getY();

    boolean tryEat();
    void init(SnakeUpdate snake);
    void relocate(SnakeUpdate snake, List<IObstacle> list);
    void paint(Graphics g);
}
