package view;

import javafx.scene.canvas.GraphicsContext;
import model.Shape;


/**
 * @author Adrian Smith/Kyle Johnson
 * @version 1
 */
public abstract class ShapeFactory {
    GraphicsContext graphics;

    public ShapeFactory(DrawingFacade canvas) {
        this.graphics = canvas.graphics;
    }

    public abstract void draw(Shape shape);

    public void setDrawStyles(Shape shape) {
        graphics.setStroke(shape.getStrokeColor());
        graphics.setFill(shape.getFillColor());
        graphics.setLineWidth(shape.getLineWidth());
    }
}
