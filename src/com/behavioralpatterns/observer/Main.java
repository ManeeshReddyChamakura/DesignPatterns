package com.behavioralpatterns.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Main {
    public static void main(String[] args) {
         NewsAgency crimeNewsAgency = new NewsAgency();
         CnnObserver cnn = new CnnObserver();
         NdtvObserver ndtv = new NdtvObserver();



         crimeNewsAgency.register(ndtv);
         crimeNewsAgency.register(cnn);


         // breaking news or change in state
         crimeNewsAgency.setNews("Earthquake in india!!!");

        /**
         * Abstract observer class case
         */
        // AbstractNewsAgency newsAgency = new AbstractNewsAgency();
        // CnnAbstractObserver cnn = new CnnAbstractObserver();
        // newsAgency.register(cnn);
        // newsAgency.setNews("Explosion!!");

        /**
         * Inbuilt observer classes
         */
        /*ANewsAgency agency = new ANewsAgency();
        AChannel channel1 = new AChannel();
        agency.register(channel1);
        agency.setNews("Volcanic Eruption!!!!!!!!!!");*/
    }
}

class ANewsAgency {
    private String news;
    private PropertyChangeSupport support;

    ANewsAgency() {
        support = new PropertyChangeSupport(this);
    }

    public void register(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void unregister(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void setNews(String news) {
        support.firePropertyChange("news", this.news, news);
        this.news = news;
    }
}

class AChannel implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("In channel " + evt.getPropertyName() + " is updated");
        System.out.println((String)evt.getNewValue() + evt.getOldValue() + evt.getSource());
    }

}
