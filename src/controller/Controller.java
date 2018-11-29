package controller;

import model.Model;
import model.Shape;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    Model model;

    public Controller(){
        model = new Model();
    }

    @Override
    public void update(Observable o, Object arg)
    {
        model.addShape(o);
    }

    public List<Shape> getShapes(){
        return model.getShapes();
    }

    public void setShapeHistory() {
//        update();

    }
}
