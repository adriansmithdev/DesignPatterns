package observer;

import java.util.HashSet;
import java.util.Set;

/**
 * Object that can be watched for changes by observers
 * @author Adrian Smith/Kyle Johnson
 * @version 1
 */
public abstract class Observable {
    //store observers
    private Set<IObserver> observers;

    /**
     * Instantiates new observable
     */
    public Observable() {
        observers = new HashSet<>();
    }

    /**
     * Adds an observer to watch this observable
     * @param observer that is watching for changes
     */
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer to no longer watch this observable
     * @param observer to discontinue listening
     */
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all observers that a change has occurred
     * @param arguments type of change that occurred
     */
    public void notifyObservers(Object... arguments) {
        for (IObserver observer : observers) {
            observer.update(this, arguments);
        }
    }

    @Override
    public String toString() {
        return "Observable{" +
                "observers=" + observers +
                '}';
    }
}