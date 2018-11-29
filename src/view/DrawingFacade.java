package view;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.Shape;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DrawingFacade extends Canvas {
    // Facade over Graphics Context to make drawing easier
    protected GraphicsContext graphics;
    private Map<ShapeType, ShapeFactory> drawingShapes;

    public DrawingFacade()
    {
        super();
        this.graphics = this.getGraphicsContext2D();

        drawingShapes = new HashMap<>();

        drawingShapes.put(ShapeType.LINE, new LineFactory(this));
        drawingShapes.put(ShapeType.OVAL, new OvalFactory(this));
        drawingShapes.put(ShapeType.RECTANGLE, new RectangleFactory(this));
        drawingShapes.put(ShapeType.SQUIGGLE, new SquiggleFactory(this));
    }

    public void init(VBox box)
    {
        this.setStyle("-fx-background-color: black");
        this.widthProperty().bind(box.widthProperty());
        this.heightProperty().bind(box.heightProperty());
    }

    public void drawShape(Shape shape)
    {
        drawingShapes.get(shape.getType()).draw(shape);
    }

    public void setFillColor(Color fillColor)
    {
        graphics.setFill(fillColor);
    }

    public Color getFillColor()
    {
        return (Color) graphics.getFill();
    }

    public void setStrokeColor(Color strokeColor)
    {
        graphics.setStroke(strokeColor);
    }

    public Color getStrokeColor()
    {
        return (Color) graphics.getStroke();
    }

    public void setLineWidth(int strokeWidth)
    {
        graphics.setLineWidth(strokeWidth);
    }

    public int getLineWidth()
    {
        return (int) graphics.getLineWidth();
    }

    public void clear()
    {
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void drawList(List<Shape> unmodShapeList)
    {
        clear();
        for (Shape shape : unmodShapeList) {
            drawingShapes.get(shape.getType()).draw(shape);
        }
    }


    public enum ShapeType {
        LINE,
        OVAL,
        RECTANGLE,
        SQUIGGLE
    }

}
