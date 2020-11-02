package com.behavioralpatterns.observer;

public class CnnObserver implements Observer{

    @Override
    public void update(Observable ob, Object data) {
        System.out.println("Cnn observer says: i got news "+(String)data);
    }

}

class CnnAbstractObserver implements AbstractObserver{

    @Override
    public void update(AbstractObservable ob, Object data) {
        System.out.println("Abstract Cnn observer says: i got news "+(String)data);
    }

}