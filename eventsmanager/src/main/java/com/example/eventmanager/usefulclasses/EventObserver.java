package com.example.eventmanager.usefulclasses;

public interface EventObserver {
    void update(Evenement event, String notificationType);
}
