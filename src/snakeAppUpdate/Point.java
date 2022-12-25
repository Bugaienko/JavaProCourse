package snakeAppUpdate;

import java.awt.*;
import java.awt.geom.Ellipse2D;


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
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(color);
        Ellipse2D ellipse2D = new Ellipse2D.Double(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
        graphics2D.fill(ellipse2D);
//        graphics2D.fillOval(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
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
