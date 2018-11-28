package observer;

public interface IObserver
{
    void update(Observable observable, Object... arguments);
}