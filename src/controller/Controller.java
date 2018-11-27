package controller;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    String shapeHistory = "";

    @Override
    public void update(Observable o, Object arg)
    {
        // model.addShape
    }

    public List<Object> getShapes(){
        return null;
    }

    public void setShapeHistory() {
        shapeHistory = "";
//        update();

    }
}
