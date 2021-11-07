package se.iths.java21.narvaez.javafx.laboration3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import se.iths.narvaez.shapes.Shapes;

public class Laboration3Controller {
    @FXML
    private Spinner<Integer> sizeSpinner;
    @FXML
    private Label spinnerLabel;
    @FXML
    private Button pointButton;
    @FXML
    private Button triangleButton;
    @FXML
    private Button rectangleButton;
    @FXML
    private Button circleButton;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Canvas canvas;
    Model model;

    public void initialize() {
        model = new Model();
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,500);
        valueFactory.setValue(50);

        sizeSpinner.setValueFactory(valueFactory);

        valueFactory.valueProperty().bindBidirectional(model.sizeProperty());
        colorPicker.valueProperty().bindBidirectional(model.colorProperty());
        canvas.widthProperty().addListener(observable -> draw());
        canvas.widthProperty().addListener(observable -> System.out.println("Canvas changed width to: " + canvas.getWidth()));
        canvas.heightProperty().addListener(observable -> draw());
        canvas.heightProperty().addListener(observable -> System.out.println("Canvas changed height to: " + canvas.getHeight()));
    }

    private void draw() {
        var graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
      for (var shape : model.shapes) {
          System.out.println("Clicked on canvas");
          shape.draw(graphicsContext);
      }
    }

    public void canvasClicked(MouseEvent event) {
        System.out.println("X - " + event.getX());
        System.out.println("Y - " + event.getY());
        if (rectangleButton.isFocused()) {
            model.shapes.add(Shapes.rectangleOf(model.getColor(), event.getX(), event.getY(), model.getSize()));
            draw();
        } else if (circleButton.isFocused()) {
            model.shapes.add(Shapes.circleOf(model.getColor(), event.getX(), event.getY(), model.getSize()));
            draw();
        } else if (triangleButton.isFocused()) {
            model.shapes.add(Shapes.triangleOf(model.getColor(), event.getX(), event.getY(), model.getSize()));
            draw();
        } else if (pointButton.isFocused()) {
            model.shapes.stream()
                    .filter(shape -> shape.isInside(event.getX(), event.getY()))
                    .findFirst().ifPresent(shape -> shape.setColor(model.getColor()));
            model.shapes.stream()
                    .filter(shape -> shape.isInside(event.getX(), event.getY()))
                    .findFirst().ifPresent(shape -> shape.setSize(model.getSize()));
            draw();
        }
    }

    public void undoClicked(ActionEvent actionEvent) {
        model.undoShape();
        draw();
    }

    public void redoShape(ActionEvent actionEvent) {
        model.redoShape();
        draw();
    }
}
