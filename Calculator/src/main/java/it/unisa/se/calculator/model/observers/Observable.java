package it.unisa.se.calculator.model.observers;

/**
 * The following interface is used to define methods for applying the Observer pattern.
 * This interface makes the class that implements it Observable, and notifies the changes to all the listeners.
 */
public interface Observable {
    void addListener(Observer observer);
    void removeListener(Observer observer);
    void notifyObservers();
}
