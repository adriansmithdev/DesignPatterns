package view;

import observer.IObserver;

import java.util.HashSet;
import java.util.List;
import java.util.Observable;

public abstract class ObservableList extends Observable {
    List<Object> shapes;

    public void addShape(){
        // add shape to list
        setChanged();
        notifyObservers();
    }

    public enum Change
    {
        ADD,
        REMOVE,
        UPDATE,
        RETRIEVE
    }
}
