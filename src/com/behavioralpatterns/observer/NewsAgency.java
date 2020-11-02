package com.behavioralpatterns.observer;

import java.util.ArrayList;
import java.util.List;


public class NewsAgency implements Observable {
    String news;
    List<Observer> observers;

    public NewsAgency() {
        observers = new ArrayList<Observer>();
        news = "";
    }

    @Override
    public void register(Observer ob) {
        if (observers.contains(ob)) return;
        observers.add(ob);
    }

    @Override
    public void unregister(Observer ob) {
        observers.remove(ob);
    }

    @Override
    public void notifyObservers(Observable observable, Object data) {
        for (Observer ob: observers) {
            ob.update(observable, data);
        }
    }

    public void setNews(String news) {
        // some data got changed
        this.news = news;
        this.notifyObservers(this, news);
    }

}






class AbstractNewsAgency extends AbstractObservable {
    String news;
    AbstractNewsAgency() {
        System.out.println("In news agency");
        this.news = "";
    }

    public void setNews(String news) {
        this.news = news;
        this.notifyObservers(this, news);
    }

}
