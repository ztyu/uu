package model.Observer;


public interface Observable {

    void registerObserver(Observer observer);

    void removeObserver(Observer observable);

    void notifyObserver();
}
