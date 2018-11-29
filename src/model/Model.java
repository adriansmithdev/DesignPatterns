package model;

import controller.Controller;

import java.util.Collections;
import java.util.List;
import observer.Observable;
import java.util.Stack;

public class Model extends Observable{
    private Controller controller;
    private Stack<Shape> shapeHistory;
    private Stack<Shape> undoHistory;

    public void addShape(Shape shape){
        shapeHistory.push(shape);
        undoHistory.clear();
        notifyObservers(Change.ADD, shape);
    }

    public void redo(){
        Shape shape = undoHistory.pop();
        shapeHistory.push(shape);

        notifyObservers(Change.ADD, shape);
    }

    public void removeShape(){
        Shape shape = shapeHistory.pop();
        undoHistory.push(shape);
        notifyObservers(Change.REMOVE, shape);
    }

    public void getShape(Shape shape){
        notifyObservers(Change.RETRIEVE, shape);
    }

    public Model()
    {
        shapeHistory = new Stack<>();
        undoHistory = new Stack<>();
    }

    public List<Shape> getShapes(){
        return Collections.unmodifiableList(shapeHistory);
    }

    public enum Change{
        ADD,
        REMOVE,
        RETRIEVE
    }
}
