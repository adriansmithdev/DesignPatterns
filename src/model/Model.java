package model;

import java.util.Collections;
import java.util.List;
import observer.Observable;
import java.util.Stack;

public class Model extends Observable{
    private Stack<Shape> shapeHistory;
    private Stack<Shape> undoHistory;

    public void addShape(Shape shape){
        shapeHistory.push(shape);
        undoHistory.clear();
        notifyObservers();
    }

    public void redo(){
        if(undoHistory.isEmpty()){
            return;
        }

        Shape shape = undoHistory.pop();
        shapeHistory.push(shape);

        notifyObservers();
    }

    public void removeShape(){
        Shape shape = shapeHistory.pop();
        undoHistory.push(shape);
        notifyObservers();
    }

    public Model()
    {
        shapeHistory = new Stack<>();
        undoHistory = new Stack<>();
    }

    public List<Shape> getShapes(){
        return Collections.unmodifiableList(shapeHistory);
    }

    public void clearHistory()
    {
        shapeHistory.clear();
        undoHistory.clear();
        notifyObservers();
    }
}
