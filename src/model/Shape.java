package model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import view.DrawingFacade.ShapeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shape {
    private ShapeType type;
    private int lineWidth;
    private List<Point2D> points;
    private boolean isFilled;
    private Color strokeColor;
    private Color fillColor;

    public Shape(ShapeType type, int lineWidth, Color strokeColor, Color fillColor)
    {
        this.type = type;
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
        this.lineWidth = lineWidth;
        points = new ArrayList<>();
        isFilled = false;
    }

    public Shape(ShapeType type, int lineWidth, Color strokeColor, Color fillColor, List<Point2D> points)
    {
        this(type, lineWidth, strokeColor, fillColor);
        this.points = points;
    }

    public Shape(ShapeType type, int lineWidth, Color strokeColor, Color fillColor, List<Point2D> points, boolean isFilled)
    {
        this(type, lineWidth, strokeColor, fillColor, points);
        this.isFilled = isFilled;
    }

    public boolean isFilled()
    {
        return isFilled;
    }

    public List<Point2D> getPoints()
    {
        return Collections.unmodifiableList(points);
    }

    public ShapeType getType()
    {
        return type;
    }

    public int getLineWidth()
    {
        return lineWidth;
    }

    public Color getStrokeColor()
    {
        return strokeColor;
    }

    public Color getFillColor()
    {
        return fillColor;
    }
}
