package view;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Shape;


public abstract class ShapeFactory {
    GraphicsContext graphics;

    public ShapeFactory(DrawingFacade canvas)
    {
        this.graphics = canvas.graphics;
    }

    public abstract void draw(Shape shape);

    public void setDrawStyles(Shape shape){
        graphics.setStroke(shape.getStrokeColor());
        graphics.setFill(shape.getFillColor());
        graphics.setLineWidth(shape.getLineWidth());
    }
}
