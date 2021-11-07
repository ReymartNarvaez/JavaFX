package se.iths.narvaez.shapes.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import se.iths.narvaez.shapes.Shape;
import static java.lang.Math.abs;

public final class Triangle extends Shape {
    double[] xCoords = new double[3];
    double[] yCoords = new double[3];

    public Triangle(Color color, double x, double y, double size) {
        super(color, x, y, size);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        xCoords[0] = getX();
        yCoords[0] = getY();
        xCoords[1] = getX()+ getSize()/2;
        yCoords[1] = getY() + getSize();
        xCoords[2] = getX()-getSize()/2;
        yCoords[2] = getY() + getSize();
        graphicsContext.setFill(getColor());
        graphicsContext.fillPolygon(xCoords,yCoords,3);
    }

    @Override
    public boolean isInside(double x, double y) {
        double areaOrig = abs( (xCoords[1]-xCoords[0])*(yCoords[2]-yCoords[0]) - (xCoords[2]-xCoords[0])*(yCoords[1]-yCoords[0]) );
        double area1 =    abs( (xCoords[0]-x)*(yCoords[1]-y) - (xCoords[1]-x)*(yCoords[0]-y) );
        double area2 =    abs( (xCoords[1]-x)*(yCoords[2]-y) - (xCoords[2]-x)*(yCoords[1]-y) );
        double area3 =    abs( (xCoords[2]-x)*(yCoords[0]-y) - (xCoords[0]-x)*(yCoords[2]-y) );
        return area1 + area2 + area3 == areaOrig;
    }
}
