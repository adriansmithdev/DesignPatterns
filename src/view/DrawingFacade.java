package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.Shape;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Abstracts javafx drawing
 * @author Adrian Smith/Kyle Johnson
 * @version 1
 */
public class DrawingFacade extends Canvas {
    // Facade over Graphics Context to make drawing easier
    private GraphicsContext graphics;
    private Map<ShapeType, ShapeFactory> drawingShapes;

    /**
     * Constructs a facade for drawing
     */
    public DrawingFacade() {
        super();
        this.setGraphics(this.getGraphicsContext2D());

        drawingShapes = new HashMap<>();

        drawingShapes.put(ShapeType.LINE, new LineFactory(this));
        drawingShapes.put(ShapeType.OVAL, new OvalFactory(this));
        drawingShapes.put(ShapeType.RECTANGLE, new RectangleFactory(this));
        drawingShapes.put(ShapeType.SQUIGGLE, new SquiggleFactory(this));
    }

    /**
     * Sets the dimensions of drawing area
     * @param box to draw in
     */
    public void init(VBox box) {
        this.setStyle("-fx-background-color: black");
        this.widthProperty().bind(box.widthProperty());
        this.heightProperty().bind(box.heightProperty());
    }

    /**
     * Draws a shape following respective factory implementation
     * @param shape to draw
     */
    public void drawShape(Shape shape) {
        drawingShapes.get(shape.getType()).draw(shape);
    }

    /**
     * Sets fill color for the next shape to draw
     * @param fillColor color of inside of object
     */
    public void setFillColor(Color fillColor) {
        getGraphics().setFill(fillColor);
    }

    /**
     * Gets teh fill color for the next shape to draw
     * @return color of fill
     */
    public Color getFillColor() {
        return (Color) getGraphics().getFill();
    }

    /**
     * Sets the color that the stroke will be
     * @param strokeColor color of border/stroke
     */
    public void setStrokeColor(Color strokeColor) {
        getGraphics().setStroke(strokeColor);
    }

    /**
     * Gets the color that the stroke will be
     * @return stroke color
     */
    public Color getStrokeColor() {
        return (Color) getGraphics().getStroke();
    }

    /**
     * Sets the width of the border/stroke
     * @param strokeWidth as int that stroke is
     */
    public void setLineWidth(int strokeWidth) {
        getGraphics().setLineWidth(strokeWidth);
    }

    /**
     * Retrieves line width
     * @return stroke width that lines are drawn
     */
    public int getLineWidth() {
        return (int) getGraphics().getLineWidth();
    }

    /**
     * Removes all drawings from the view
     */
    public void clear() {
        getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
    }

    /**
     * Draws all shapes in a list
     * @param unmodShapeList list of shapes to draw that is unmodifiable
     */
    public void drawList(List<Shape> unmodShapeList) {
        clear();
        for (Shape shape : unmodShapeList) {
            drawingShapes.get(shape.getType()).draw(shape);
        }
    }

    /**
     * Returns current graphics context
     * @return context for current view
     */
    public GraphicsContext getGraphics() {
        return graphics;
    }


    /**
     * Sets the current graphics context
     * @param graphics for current view
     */
    public void setGraphics(GraphicsContext graphics) {
        this.graphics = graphics;
    }


    public enum ShapeType {
        LINE,
        OVAL,
        RECTANGLE,
        SQUIGGLE
    }

    @Override
    public String toString() {
        return "DrawingFacade{" +
                "graphics=" + getGraphics() +
                ", drawingShapes=" + drawingShapes +
                '}';
    }
}
