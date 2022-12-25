package snakeAppUpdate;

import java.awt.*;


import static snakeAppUpdate.MainGameSnake.DEFAULT_COLOR;
import static snakeAppUpdate.MainGameSnake.POINT_RADIUS;


public class Point {
    private int x, y;
    private Color color;

    public Color getColor() {
        return color;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = DEFAULT_COLOR;
    }
    void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
    }

    public void  setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y + " " +
                '}';
    }
}
