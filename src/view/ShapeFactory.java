package view;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public abstract class ShapeFactory {
    GraphicsContext graphics;

    public ShapeFactory(DrawingFacade canvas)
    {
        this.graphics = canvas.graphics;
    }

    public abstract void draw(List<Point2D> points, boolean isFilled);
}
