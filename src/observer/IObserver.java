package observer;

/**
 * Watches observables for changes
 * @author Adrian Smith/Kyle Johnson
 * @version 1
 */
public interface IObserver {
    /**
     * Used to notify observers that object has changed
     * @param observable that sent the notification
     * @param arguments of type change that occurred and argument
     */
    void update(Observable observable, Object... arguments);
}