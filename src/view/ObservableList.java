package view;

import javafx.application.Application;

import java.util.List;
import java.util.Observable;

public abstract class ObservableList extends Observable {
    List<Object> shapes;

    public void addShape(){
        // add shape to list
        setChanged();
        notifyObservers();
    }
}
