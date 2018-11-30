package view;

import javafx.scene.canvas.GraphicsContext;
import model.Shape;


/**
 * Handles drawing differnt types of shaps
 * @author Adrian Smith/Kyle Johnson
 * @version 1
 */
public abstract class ShapeFactory {
    private GraphicsContext graphics;

    /**
     * Create a factory on the given canvas
     * @param canvas to draw to
     */
    public ShapeFactory(DrawingFacade canvas) {
        this.setGraphics(canvas.getGraphics());
    }

    /**
     * Draw a shape to the canvas
     * @param shape to draw
     */
    public abstract void draw(Shape shape);

    /**
     * Set drawing styles on canvas to match shape
     * @param shape to draw
     */
    public void setDrawStyles(Shape shape) {
        getGraphics().setStroke(shape.getStrokeColor());
        getGraphics().setFill(shape.getFillColor());
        getGraphics().setLineWidth(shape.getLineWidth());
    }

    @Override
    public String toString() {
        return "ShapeFactory{" +
                "graphics=" + getGraphics() +
                '}';
    }

    /**
     * Retrieves the active graphics context
     * @return graphics to draw to
     */
    protected GraphicsContext getGraphics() {
        return graphics;
    }

    /**
     * Sets the active graphics to use for drawing
     * @param graphics to set
     */
    protected void setGraphics(GraphicsContext graphics) {
        this.graphics = graphics;
    }
}
