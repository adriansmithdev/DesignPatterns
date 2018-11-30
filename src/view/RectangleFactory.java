package view;

import javafx.geometry.Point2D;
import model.Shape;

import java.util.List;

/**
 * Handles drawing rectangles
 * @author Adrian Smith/Kyle Johnson
 * @version 1
 */
public class RectangleFactory extends ShapeFactory {
    /**
     * Constructs a rectangle factory
     * @param canvas that the factory is drawing to
     */
    public RectangleFactory(DrawingFacade canvas) {
        super(canvas);
    }

    @Override
    public void draw(Shape shape) {
        setDrawStyles(shape);
        drawRectangle(shape.getPoints(), shape.isFilled());
    }

    private void drawRectangle(List<Point2D> points, boolean isFilled) {
        double xCoord = Math.min(points.get(0).getX(), points.get(1).getX());
        double yCoord = Math.min(points.get(0).getY(), points.get(1).getY());
        double width = Math.abs(points.get(1).getX() - points.get(0).getX());
        double height = Math.abs(points.get(1).getY() - points.get(0).getY());
        if (isFilled) {
            getGraphics().fillRect(xCoord, yCoord, width, height);
        }
        getGraphics().strokeRect(xCoord, yCoord, width, height);
    }
}
