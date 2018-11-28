package observer;

import java.util.HashSet;
import java.util.Set;

public abstract class Observable
{
    //store observers
    private Set<IObserver> observers;

    public Observable()
    {
        observers = new HashSet<>();
    }

    public void addObserver(IObserver observer)
    {
        observers.add(observer);
    }

    public void removeObserver(IObserver observer)
    {
        observers.remove(observer);
    }

    public void notifyObservers(Object... arguments)
    {
        for (IObserver observer : observers)
        {
            observer.update(this, arguments);
        }
    }
}