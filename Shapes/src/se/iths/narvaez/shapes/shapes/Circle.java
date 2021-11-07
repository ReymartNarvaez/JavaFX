package se.iths.narvaez.shapes.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import se.iths.narvaez.shapes.Shape;

public final class Circle extends Shape {
    public Circle(Color color, double x, double y, double size) {
        super(color, x, y, size);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(this.getColor());
        graphicsContext.fillOval(getX()-getSize()/2, getY()-getSize()/2, getSize(),getSize());
    }

    @Override
    public boolean isInside(double x, double y) {
        double dx = x - getX();
        double dy = y - getY();
        double distanceFromCircleCenterSquared = dx * dx + dy * dy ;
        return distanceFromCircleCenterSquared < getSize()/2 * getSize()/2;
    }
}
