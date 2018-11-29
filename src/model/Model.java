package model;

import controller.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Stack;

public class Model {
    Controller controller;
    Stack<Shape> shapeHistory;
    Stack<Shape> undoHistory;

    public Model(){
        controller = new Controller();
        shapeHistory = new Stack<>();
        undoHistory = new Stack<>();
    }

    public List<Shape> getShapes(){
        return Collections.unmodifiableList(shapeHistory);
    }

    public void addShape(Observable o)
    {

    }
}
