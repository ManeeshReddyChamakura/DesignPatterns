package com.behavioralpatterns.observer;

public interface Observer {
    public void update(Observable ob, Object data);
}
















interface AbstractObserver {
    public void update(AbstractObservable ob, Object data);
}
