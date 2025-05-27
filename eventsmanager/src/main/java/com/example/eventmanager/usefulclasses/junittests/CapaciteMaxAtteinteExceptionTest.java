package com.example.eventmanager.usefulclasses.junittests;

import com.example.eventmanager.usefulclasses.Concert;
import com.example.eventmanager.usefulclasses.EventFactory;
import com.example.eventmanager.usefulclasses.Participant;
import com.example.eventmanager.usefulclasses.exceptions.CapaciteMaxAtteinteException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

class CapaciteMaxAtteinteExceptionTest {

    @Test
    void testExceptionMessage() {
        String eventName = "Tech Conference";
        int maxCapacity = 100;
        CapaciteMaxAtteinteException exception = new CapaciteMaxAtteinteException(eventName, maxCapacity);

        // Verify the exception message
        assertEquals("L'événement 'Tech Conference' a atteint sa capacité maximale (100 participants).", exception.getMessage());
    }

    @Test
    void testExceptionWithCause() throws CapaciteMaxAtteinteException {
        /*String message = "Custom error message";
        Throwable cause = new IllegalArgumentException("Invalid argument");
        CapaciteMaxAtteinteException exception = new CapaciteMaxAtteinteException(message, cause);

        // Verify the exception message and cause
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());*/

        Concert concert = EventFactory.createConcert("AdamSTour", LocalDateTime.now(), "Melen", 1, "Drake", "Rap");
        Participant participant1 = new Participant("Drew", "drewbeckeley@gmail.com");
        Participant participant2 = new Participant("Johnny", "Johnnydoe@gmail.com");
        concert.ajouterParticipant(participant1);
        assertThrows(CapaciteMaxAtteinteException.class, () ->{concert.ajouterParticipant(participant2);});
        
    }
}
