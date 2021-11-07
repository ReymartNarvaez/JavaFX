package se.iths.narvaez.shapes.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import se.iths.narvaez.shapes.Shape;

public final class Rectangle extends Shape {
    public Rectangle(Color color, double x, double y, double size) {
        super(color, x, y, size);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(this.getColor());
        graphicsContext.fillRect(getX()- getSize()/2, getY()- getSize()/2, getSize(),getSize());
    }

    @Override
    public boolean isInside(double x, double y) {
        double xPosition = getX() - getSize()/2;
        double yPosition = getY() - getSize()/2;
        double width = getSize();
        double height = getSize();

        return x >= xPosition &&
                x <= xPosition + width &&
                y >= yPosition &&
                y <= yPosition + height;
    }
}
