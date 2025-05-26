/*package com.example.eventmanager.usefulclasses.junittests;

import com.example.eventmanager.addParticipantController;

import com.example.eventmanager.usefulclasses.Conference;
import com.example.eventmanager.usefulclasses.GestionEvenements;
import com.example.eventmanager.usefulclasses.Participant;
import com.example.eventmanager.usefulclasses.exceptions.CapaciteMaxAtteinteException;
import com.example.eventmanager.usefulclasses.serializers.JsonDataManager;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class addParticipantControllerTest {

    private addParticipantController controller;
    private Conference mockConference;

    @BeforeEach
    void setUp() {
        addParticipantController controller = new addParticipantController();

        // Mock the FXML fields
        controller.getNomparticipanttf() = new TextField();
        controller.getEmailpartf() = new TextField();
        controller.getEventlb() = new Label();

        // Mock a Conference object
        mockConference = mock(Conference.class);

        // Mock GestionEvenements behavior
        GestionEvenements gestionEvenementsMock = mock(GestionEvenements.class);
        when(GestionEvenements.rechercherEvenement(anyString())).thenReturn(mockConference);
    }

    @Test
    void testAddToEventSuccess() throws CapaciteMaxAtteinteException {
        // Set up input values
        controller.nomparticipanttf.setText("John Doe");
        controller.emailpartf.setText("john.doe@example.com");
        controller.eventlb.setText("Tech Conference");

        // Call the method
        controller.addToEvent(null);

        // Verify that the participant was added to the conference
        verify(mockConference, times(1)).ajouterParticipant(any(Participant.class));

        // Verify that the event was saved
        assertDoesNotThrow(JsonDataManager::saveEvents);
    }

    @Test
    void testAddToEventCapacityMaxReached() throws CapaciteMaxAtteinteException {
        // Set up input values
        controller.nomparticipanttf.setText("John Doe");
        controller.emailpartf.setText("john.doe@example.com");
        controller.eventlb.setText("Tech Conference");

        // Simulate capacity max reached exception
        doThrow(new CapaciteMaxAtteinteException("Tech Conference", 100)).when(mockConference).ajouterParticipant(any(Participant.class));

        // Call the method and verify exception handling
        assertDoesNotThrow(() -> controller.addToEvent(null));

        // Verify that the exception was caught and handled
        verify(mockConference, times(1)).ajouterParticipant(any(Participant.class));
    }
}*/
