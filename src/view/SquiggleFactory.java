package view;

import javafx.geometry.Point2D;
import model.Shape;

import java.util.List;

/**
 * @author Adrian Smith/Kyle Johnson
 * @version 1
 */
public class SquiggleFactory extends ShapeFactory {
    /**
     * Constructs a squiggle factory
     * @param canvas that the factory is drawing to
     */
    public SquiggleFactory(DrawingFacade canvas) {
        super(canvas);
    }

    @Override
    public void draw(Shape shape) {
        setDrawStyles(shape);
        drawSquiggle(shape.getPoints(), shape.isFilled());
    }

    private void drawSquiggle(List<Point2D> points, boolean isFilled) {
        double[] xCoord, yCoord;
        xCoord = new double[points.size()];
        yCoord = new double[points.size()];

        for (int i = 0; i < points.size(); i++) {
            Point2D point = points.get(i);
            xCoord[i] = point.getX();
            yCoord[i] = point.getY();
        }

        getGraphics().strokePolyline(xCoord, yCoord, points.size());
        if (isFilled) {
            getGraphics().fillPolygon(xCoord, yCoord, points.size());
        }
    }
}
