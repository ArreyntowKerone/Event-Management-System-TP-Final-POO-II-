package com.example.eventmanager.usefulclasses.junittests;

import com.example.eventmanager.usefulclasses.exceptions.EvenementDejaExistantException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        String message = "Custom error message";
        Throwable cause = new IllegalArgumentException("Invalid argument");
        EvenementDejaExistantException exception = new EvenementDejaExistantException(message, cause);

        // Verify the exception message and cause
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}
