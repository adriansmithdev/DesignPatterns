package view;

import javafx.geometry.Point2D;

import java.util.List;

public class LineFactory extends ShapeFactory {
    public LineFactory(DrawingFacade canvas)
    {
        super(canvas);
    }

    @Override
    public void draw(List<Point2D> points, boolean isFilled)
    {
        drawLine(points);
    }

    private void drawLine(List<Point2D> points)
    {
        graphics.strokeLine(points.get(0).getX(), points.get(0).getY(), points.get(1).getX(), points.get(1).getY());
    }
}