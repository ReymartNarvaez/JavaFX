package se.iths.java21.narvaez.javafx.laboration3;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import se.iths.narvaez.shapes.Shape;


import java.util.*;

public class Model {
    private StringProperty text;
    private final BooleanProperty inColor;
    private final ObjectProperty<Color> color;
    private final ObjectProperty<Integer> size;
    Deque<Shape> shapes = new ArrayDeque<>();
    Deque<Shape> removedShape = new ArrayDeque<>();

    public Model() {
        this.text = new SimpleStringProperty();
        this.inColor = new SimpleBooleanProperty();
        this.color = new SimpleObjectProperty<>(Color.BLACK);
        this.size = new SimpleObjectProperty<>(50);
    }

    public void undoShape() {
        if (shapes.isEmpty())
            return;
        removedShape.add(shapes.getLast());
        shapes.removeLast();
    }

    public void redoShape(){
        if (removedShape.isEmpty())
        return;
        shapes.add(removedShape.getLast());
        removedShape.removeLast();
    }

    public Integer getSize() {
        return size.get();
    }

    public ObjectProperty<Integer> sizeProperty() {
        return size;
    }

    public void setSize(Integer size) {
        this.size.set(size);
    }

    public Color getColor() {
        return color.get();
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public boolean isInColor() {
        return inColor.get();
    }

    public BooleanProperty inColorProperty() {
        return inColor;
    }

    public void setInColor(boolean inColor) {
        this.inColor.set(inColor);
    }

    public String getText() {
        return text.getValue();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    public StringProperty textProperty(){
        return text;
    }
}
