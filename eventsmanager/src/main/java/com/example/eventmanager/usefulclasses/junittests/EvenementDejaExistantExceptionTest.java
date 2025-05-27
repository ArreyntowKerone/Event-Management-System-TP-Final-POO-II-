package com.example.eventmanager.usefulclasses.junittests;

import com.example.eventmanager.usefulclasses.Concert;
import com.example.eventmanager.usefulclasses.EventFactory;
import com.example.eventmanager.usefulclasses.GestionEvenements;
import com.example.eventmanager.usefulclasses.exceptions.EvenementDejaExistantException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

class EvenementDejaExistantExceptionTest {

    @Test
    void testExceptionMessage() {
        String eventName = "Tech Conference";
        EvenementDejaExistantException exception = new EvenementDejaExistantException(eventName);

        // Verify the exception message
        assertEquals("L'événement avec le nom'Tech Conference' existe déjà.", exception.getMessage());
    }

    @Test
    void testExceptionWithCause() {
        Concert concert = EventFactory.createConcert("AdamsTour", LocalDateTime.now(), "Melen", 1, "Drake", "Rap");
        GestionEvenements.getInstance().ajouterEvenement(concert.getNom(), concert);
        Concert concert2 = EventFactory.createConcert("AdamsTour", LocalDateTime.now(), "Melen", 1, "Drake", "Rap");
        assertThrows(EvenementDejaExistantException.class, () ->{ GestionEvenements.getInstance().ajouterEvenement(concert2.getNom(), concert2);});
        /*String message = "Custom error message";
        Throwable cause = new IllegalArgumentException("Invalid argument");
        EvenementDejaExistantException exception = new EvenementDejaExistantException(message, cause);

        // Verify the exception message and cause
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());*/
    }
}
