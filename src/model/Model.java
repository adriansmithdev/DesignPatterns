package model;

import observer.Observable;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Model stores/changes to drawing
 * @author Adrian Smith/Kyle Johnson
 * @version 1
 */
public class Model extends Observable {
    private Stack<Shape> shapeHistory;
    private Stack<Shape> undoHistory;

    /**
     * Creates a model object for drawing data
     */
    public Model() {
        shapeHistory = new Stack<>();
        undoHistory = new Stack<>();
    }

    /**
     * Redoes the last undone item
     * Add calls remove the history of changes
     */
    public void redo() {
        if (undoHistory.isEmpty()) {
            return;
        }

        Shape shape = undoHistory.pop();
        shapeHistory.push(shape);

        notifyObservers();
    }

    /**
     * Adds a shape to the drawing history and clears undo state
     * @param shape to add to history
     */
    public void addShape(Shape shape) {
        shapeHistory.push(shape);
        undoHistory.clear();
        notifyObservers();
    }

    /**
     * Removes the most recent history item i.e. like undo
     */
    public void removeShape() {
        Shape shape = shapeHistory.pop();
        undoHistory.push(shape);
        notifyObservers();
    }

    /**
     * Returns a unmodifiable list of shapes that have been drawn
     * @return a list of all the shapes
     */
    public List<Shape> getShapes() {
        return Collections.unmodifiableList(shapeHistory);
    }

    /**
     * Clears all shapes that have been drawn
     */
    public void clearHistory() {
        shapeHistory.clear();
        undoHistory.clear();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Model{" +
                "shapeHistory=" + shapeHistory +
                ", undoHistory=" + undoHistory +
                '}';
    }
}
