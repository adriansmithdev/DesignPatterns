package view;

import javafx.geometry.Point2D;
import model.Shape;

import java.util.List;

/**
 * @author Adrian Smith/Kyle Johnson
 * @version 1
 */
public class OvalFactory extends ShapeFactory {

    public OvalFactory(DrawingFacade canvas) {
        super(canvas);
    }

    @Override
    public void draw(Shape shape) {
        setDrawStyles(shape);
        drawOval(shape.getPoints(), shape.isFilled());
    }

    private void drawOval(List<Point2D> points, boolean isFilled) {
        double x = Math.min(points.get(0).getX(), points.get(1).getX());
        double y = Math.min(points.get(0).getY(), points.get(1).getY());
        double width = Math.abs(points.get(1).getX() - points.get(0).getX());
        double height = Math.abs(points.get(1).getY() - points.get(0).getY());
        if (isFilled) {
            graphics.fillOval(x, y, width, height);
        }
        graphics.strokeOval(x, y, width, height);
    }
}
