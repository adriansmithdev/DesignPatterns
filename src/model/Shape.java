package model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import view.DrawingFacade.ShapeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Shape object which stores information for shape to draw
 * @author Adrian Smith/Kyle Johnson
 * @version 1
 */
public class Shape {
    private ShapeType type;
    private int lineWidth;
    private List<Point2D> points;
    private boolean isFilled;
    private Color strokeColor;
    private Color fillColor;

    /**
     * Creates a shape with given parameters
     * @param type of shape
     * @param lineWidth of shape line
     * @param strokeColor of shape line
     * @param fillColor of shape body
     */
    public Shape(ShapeType type, int lineWidth, Color strokeColor, Color fillColor) {
        this.type = type;
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
        this.lineWidth = lineWidth;
        points = new ArrayList<>();
        isFilled = false;
    }

    /**
     * Creates a shape with given parameters
     * @param type of shape
     * @param lineWidth of shape line
     * @param strokeColor of shape line
     * @param fillColor of shape body
     * @param points list of coordinates covered
     */
    public Shape(ShapeType type, int lineWidth, Color strokeColor, Color fillColor, List<Point2D> points) {
        this(type, lineWidth, strokeColor, fillColor);
        this.points = points;
    }

    /**
     * Creates a shape with given parameters
     * @param type of shape
     * @param lineWidth of shape line
     * @param strokeColor of shape line
     * @param fillColor of shape body
     * @param points list of coordinates covered
     * @param isFilled does shape have solid center
     */
    public Shape(ShapeType type, int lineWidth, Color strokeColor, Color fillColor, List<Point2D> points, boolean isFilled) {
        this(type, lineWidth, strokeColor, fillColor, points);
        this.isFilled = isFilled;
    }

    /**
     * Is the shape coloring the center or leaving opaque
     * @return if the shape is filled in center
     */
    public boolean isFilled() {
        return isFilled;
    }

    /**
     * All points the shape spans
     * Points order is interpreted in shape factories
     * @return a list of points for shape
     */
    public List<Point2D> getPoints() {
        return Collections.unmodifiableList(points);
    }

    /**
     * The type of shape this is
     * @return the shape type from enum
     */
    public ShapeType getType() {
        return type;
    }

    /**
     * Width of the stroke or border
     * @return the width as an integer
     */
    public int getLineWidth() {
        return lineWidth;
    }

    /**
     * Color of the stroke or border
     * @return the color set
     */
    public Color getStrokeColor() {
        return strokeColor;
    }

    /**
     * Gets the fill color set
     * @return color of filling
     */
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "type=" + type +
                ", lineWidth=" + lineWidth +
                ", points=" + points +
                ", isFilled=" + isFilled +
                ", strokeColor=" + strokeColor +
                ", fillColor=" + fillColor +
                '}';
    }
}
