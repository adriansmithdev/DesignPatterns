package controller;

import model.Model;
import model.Shape;
import view.DoodleView;

import java.util.List;
public class Controller{

    Model model;
    DoodleView view;

    public Controller(DoodleView view){
        model = new Model();
        this.view = view;
        model.addObserver(view);
    }

    public List<Shape> getShapes(){
        return model.getShapes();
    }

    public void addShape(Shape shape){
        model.addShape(shape);
    }

    public void removeShape(){
        model.removeShape();
    }


    public void clearHistory()
    {
        model.clearHistory();
    }

    public void redo()
    {
        model.redo();
    }
}
