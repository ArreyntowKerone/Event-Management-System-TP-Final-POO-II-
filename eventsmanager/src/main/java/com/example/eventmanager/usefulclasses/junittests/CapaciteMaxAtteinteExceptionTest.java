package com.example.eventmanager.usefulclasses.junittests;

import com.example.eventmanager.usefulclasses.exceptions.CapaciteMaxAtteinteException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    void testExceptionWithCause() {
        String message = "Custom error message";
        Throwable cause = new IllegalArgumentException("Invalid argument");
        CapaciteMaxAtteinteException exception = new CapaciteMaxAtteinteException(message, cause);

        // Verify the exception message and cause
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}
