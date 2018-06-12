package ch2;

/**
 * Created by yjw on 18-4-17.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
