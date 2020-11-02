package com.behavioralpatterns.observer;

import java.util.List;
import java.util.ArrayList;

public interface Observable {
    public void register(Observer ob);
    public void unregister(Observer ob);
    public void notifyObservers(Observable ob, Object data);
}




abstract class AbstractObservable {
    List<AbstractObserver> observers;

    public AbstractObservable() {
        observers = new ArrayList<AbstractObserver>();
        System.out.println("In abstract constructor");
    }

    public void register(AbstractObserver ob) {
        if (observers.contains(ob)) return;
        observers.add(ob);
    }

    public void unregister(AbstractObserver ob) {
        observers.remove(ob);
    }

    public void notifyObservers(AbstractObservable observable, Object data) {
        for (AbstractObserver ob: observers) {
            ob.update(observable, data);
        }
    }
}
