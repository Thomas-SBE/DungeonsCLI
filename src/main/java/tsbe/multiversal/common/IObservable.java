package tsbe.multiversal.common;

public interface IObservable {

    void notify(IObserver.NotificationType type);
    void notify(IObserver.NotificationType type, Object[] data);
    void addListener(IObserver o);
    void removeListener(IObserver o);

}
