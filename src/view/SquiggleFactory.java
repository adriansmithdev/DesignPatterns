package view;

import javafx.geometry.Point2D;
import model.Shape;

import java.util.List;

public class SquiggleFactory extends ShapeFactory {
    public SquiggleFactory(DrawingFacade canvas)
    {
        super(canvas);
    }

    @Override
    public void draw(Shape shape)
    {
        setDrawStyles(shape);
        drawSquiggle(shape.getPoints(), shape.isFilled());
    }

    private void drawSquiggle(List<Point2D> points, boolean isFilled)
    {
        double[] x, y;
        x = new double[points.size()];
        y = new double[points.size()];

        for (int i = 0; i < points.size(); i++) {
            Point2D point = points.get(i);
            x[i] = point.getX();
            y[i] = point.getY();
        }

        graphics.strokePolyline(x, y, points.size());
        if (isFilled) {
            graphics.fillPolygon(x, y, points.size());
        }
    }
}
