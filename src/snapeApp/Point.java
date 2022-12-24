package snapeApp;

import java.awt.*;

import static snapeApp.GameSnake.*;


public class Point {
    private int x, y;
    private Color color;

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
}
