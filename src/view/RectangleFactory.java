package view;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import model.Shape;

import java.util.List;

public class RectangleFactory extends ShapeFactory {
    public RectangleFactory(DrawingFacade canvas)
    {
        super(canvas);
    }

    @Override
    public void draw(Shape shape)
    {
        setDrawStyles(shape);
        drawRectangle(shape.getPoints(), shape.isFilled());
    }

    private void drawRectangle(List<Point2D> points, boolean isFilled)
    {
        double x = Math.min(points.get(0).getX(), points.get(1).getX());
        double y = Math.min(points.get(0).getY(), points.get(1).getY());
        double width = Math.abs(points.get(1).getX() - points.get(0).getX());
        double height = Math.abs(points.get(1).getY() - points.get(0).getY());
        if (isFilled) {
            graphics.fillRect(x, y, width, height);
        }
        graphics.strokeRect(x, y, width, height);
    }
}
