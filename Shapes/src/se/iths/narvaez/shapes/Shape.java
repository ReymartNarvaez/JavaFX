package se.iths.narvaez.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import se.iths.narvaez.shapes.shapes.Circle;
import se.iths.narvaez.shapes.shapes.Rectangle;
import se.iths.narvaez.shapes.shapes.Triangle;

public abstract sealed class Shape permits Circle, Rectangle, Triangle {
    private Color color;
    private double x;
    private double y;
    private double size;

    public Shape(Color color, double x, double y, double size) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public Shape setSize(double size) {
        this.size = size;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public Shape setColor(Color color) {
        this.color = color;
        return this;
    }

    public double getX() {
        return x;
    }

    public Shape setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public Shape setY(double y) {
        this.y = y;
        return this;
    }

    public abstract void draw(GraphicsContext graphicsContext);

    public abstract boolean isInside(double x, double y);
}
