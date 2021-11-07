package se.iths.narvaez.shapes;

import javafx.scene.paint.Color;

import se.iths.narvaez.shapes.shapes.Circle;
import se.iths.narvaez.shapes.shapes.Rectangle;
import se.iths.narvaez.shapes.shapes.Triangle;

public class Shapes {

    public static Shape circleOf(Color color, double x, double y, double size){
        return new Circle(color,x,y,size);
    }

    public static Shape rectangleOf( Color color, double x, double y, double size){
        return new Rectangle(color,x,y,size);
    }

    public static Shape triangleOf(Color color, double x, double y, double size){
        return new Triangle(color,x,y,size);
    }
}
