package model;

import javafx.geometry.Point2D;
import view.DrawingFacade;
import view.DrawingFacade.ShapeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shape {
    private ShapeType type;
    private List<Point2D> points;
    private boolean isFilled;

    public Shape(ShapeType type){
        this.type = type;
        points = new ArrayList<>();
        isFilled = false;
    }

    public Shape(ShapeType type, List<Point2D> points){
        this(type);
        this.points = points;
    }

    public Shape(ShapeType type, List<Point2D> points, boolean isFilled){
        this(type, points);
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

}
