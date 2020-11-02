package com.behavioralpatterns.observer;

public class NdtvObserver implements Observer{
    @Override
    public void update(Observable ob, Object data) {
        // some implementation
        System.out.println("Ndtv says: i got news "+ (String)data);
    }
}

