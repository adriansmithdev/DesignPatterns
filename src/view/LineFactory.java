package view;

import javafx.geometry.Point2D;
import model.Shape;

import java.util.List;

/**
 * Handles drawing single lines
 * @author Adrian Smith/Kyle Johnson
 * @version 1
 */
public class LineFactory extends ShapeFactory {
    /**
     * Constructs a line factory
     * @param canvas that the factory is drawing to
     */
    public LineFactory(DrawingFacade canvas) {
        super(canvas);
    }

    @Override
    public void draw(Shape shape) {
        setDrawStyles(shape);
        drawLine(shape.getPoints());
    }

    private void drawLine(List<Point2D> points) {
        getGraphics().strokeLine(points.get(0).getX(), points.get(0).getY(), points.get(1).getX(), points.get(1).getY());
    }
}
