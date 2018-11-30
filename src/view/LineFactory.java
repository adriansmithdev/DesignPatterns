package view;

import javafx.geometry.Point2D;
import model.Shape;

import java.util.List;

/**
 * @author Adrian Smith/Kyle Johnson
 * @version 1
 */
public class LineFactory extends ShapeFactory {
    public LineFactory(DrawingFacade canvas) {
        super(canvas);
    }

    @Override
    public void draw(Shape shape) {
        setDrawStyles(shape);
        drawLine(shape.getPoints());
    }

    private void drawLine(List<Point2D> points) {
        graphics.strokeLine(points.get(0).getX(), points.get(0).getY(), points.get(1).getX(), points.get(1).getY());
    }
}
