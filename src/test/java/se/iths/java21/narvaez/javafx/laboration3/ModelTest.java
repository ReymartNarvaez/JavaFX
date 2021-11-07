package se.iths.java21.narvaez.javafx.laboration3;

import org.junit.jupiter.api.Test;
import se.iths.narvaez.shapes.Shapes;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    Laboration3Controller labb3 = new Laboration3Controller();
    Model model = new Model();
    @Test
   void removingShapeFromShapesListAndAddningTheRemovedShapeToRemovedShapeList(){
       model.shapes.add(Shapes.circleOf(model.getColor(), 10, 10, model.getSize()));
       model.undoShape();
       var result = model.shapes.size();
       assertEquals(0,result);
   }

   @Test
   void addingBackShapeToShapeListAndRemovingShapeFromRemovedList(){
       model.removedShape.add(Shapes.circleOf(model.getColor(), 10, 10, 1));
       model.redoShape();
       var result = model.shapes.size();
       assertEquals(1,result);
   }

    @Test
    void setSizeForShape(){
        model.setSize(1);
        var result = model.getSize();
        assertEquals(1,result);
    }
}

