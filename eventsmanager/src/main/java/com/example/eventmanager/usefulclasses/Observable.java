package com.example.eventmanager.usefulclasses;

import java.util.ArrayList;
import java.util.List;


public abstract class Observable {
    private List<EventObserver> observers = new ArrayList<>();
    
    //NB: When I deal with adding participants to an event I should not forget to always add the participant to the observer list
    public void addObserver(EventObserver observer) {
        observers.add(observer);
    }
    
    public void removeObserver(EventObserver observer) {
        observers.remove(observer);
    }
    
    public void notifyObservers(Evenement event, String notificationType) {
        for (EventObserver observer : observers) {
            observer.update(event, notificationType);
        }
    }
}
