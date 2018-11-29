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

    public DrawingFacade(){
        super();
        this.graphics = this.getGraphicsContext2D();

        drawingShapes = new HashMap<>();

        drawingShapes.put(ShapeType.LINE, new LineFactory(this));
        drawingShapes.put(ShapeType.OVAL, new OvalFactory(this));
        drawingShapes.put(ShapeType.RECTANGLE, new RectangleFactory(this));
        drawingShapes.put(ShapeType.SQUIGGLE, new SquiggleFactory(this));
    }

    public void init(VBox box){
        this.setStyle("-fx-background-color: black");
        this.widthProperty().bind(box.widthProperty());
        this.heightProperty().bind(box.heightProperty());
    }

    public void drawShape(ShapeType shape, List<Point2D> points, boolean isFilled)
    {
        drawingShapes.get(shape).draw(points, isFilled);
    }

    public void setFill(Color fillColor){
        graphics.setFill(fillColor);
    }

    public void setStroke(Color strokeColor)
    {
        graphics.setStroke(strokeColor);
    }

    public void setLineWidth(int strokeWidth)
    {
        graphics.setLineWidth(strokeWidth);
    }

    public void clear()
    {
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void drawList(List<Shape> unModifiableShapeList)
    {
        for(Shape shape : unModifiableShapeList){
            drawingShapes.get(shape.getType()).draw(shape.getPoints(), shape.isFilled());
        }
    }


    public enum ShapeType{
        LINE,
        OVAL,
        RECTANGLE,
        SQUIGGLE
    }

}
