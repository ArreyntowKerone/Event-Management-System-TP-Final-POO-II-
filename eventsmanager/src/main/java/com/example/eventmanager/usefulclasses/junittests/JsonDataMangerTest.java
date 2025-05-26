package com.example.eventmanager.usefulclasses.junittests;

import com.example.eventmanager.usefulclasses.Evenement;
import com.example.eventmanager.usefulclasses.EventFactory;
import com.example.eventmanager.usefulclasses.GestionEvenements;
import com.example.eventmanager.usefulclasses.Participant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.eventmanager.usefulclasses.serializers.JsonDataManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonDataManagerTest {

    @TempDir
    Path tempDir;
    private File testEventsFile;
    private File testParticipantsFile;
    private Evenement testEvent;
    private Participant testParticipant;

    @BeforeEach
    void setUp() {
        // Override the default file paths with temporary test files
        JsonDataManager.EVENEMENTS_FILE = tempDir.resolve("test_events.json").toString();
        JsonDataManager.PARTICIPANTS_FILE = tempDir.resolve("test_participants.json").toString();

        // Create test data
        testEvent = EventFactory.createConcert("HighSchoolMusical", LocalDateTime.now(), "Damas", 25, "KO-C", "AnimeRap");
        testParticipant = new Participant("John", "john.doe@example.com");

        // Clear any existing data
        GestionEvenements.getEvenements().clear();
        GestionEvenements.getPersonnes().clear();
    }

    @AfterEach
    void tearDown() {
        // Clean up after each test
        GestionEvenements.getEvenements().clear();
        GestionEvenements.getPersonnes().clear();
    }

    @Test
    void testSaveAndLoadEvents() throws IOException {
        // Add test data to the management system
        GestionEvenements.getEvenements().put("event1", testEvent);
        GestionEvenements.getPersonnes().put(testParticipant, testEvent);

        // Save to JSON files
        JsonDataManager.saveEvents();

        // Clear the in-memory data
        GestionEvenements.getEvenements().clear();
        GestionEvenements.getPersonnes().clear();

        // Load from JSON files
        JsonDataManager.loadEvents();

        // Verify the data was correctly saved and loaded
        assertEquals(1, GestionEvenements.getEvenements().size());
        assertEquals(1, GestionEvenements.getPersonnes().size());
        assertTrue(GestionEvenements.getEvenements().containsKey("event1"));
        assertTrue(GestionEvenements.getPersonnes().containsKey(testParticipant));
    }

    @Test
    void testSaveEventsWithEmptyData() throws IOException {
        // Ensure collections are empty
        GestionEvenements.getEvenements().clear();
        GestionEvenements.getPersonnes().clear();

        // Should not throw exceptions with empty data
        assertDoesNotThrow(() -> JsonDataManager.saveEvents());

        // Verify files were created
        assertTrue(new File(JsonDataManager.EVENEMENTS_FILE).exists());
        assertTrue(new File(JsonDataManager.PARTICIPANTS_FILE).exists());
    }

    @Test
    void testLoadEventsWithMissingFiles() {
        // Delete files if they exist
        new File(JsonDataManager.EVENEMENTS_FILE).delete();
        new File(JsonDataManager.PARTICIPANTS_FILE).delete();

        // Should not throw exceptions when files don't exist
        assertDoesNotThrow(() -> JsonDataManager.loadEvents());

        // Verify collections remain empty
        assertTrue(GestionEvenements.getEvenements().isEmpty());
        assertTrue(GestionEvenements.getPersonnes().isEmpty());
    }

    @Test
    void testSaveEventsWithInvalidPath() {
        // Set invalid file paths
        JsonDataManager.EVENEMENTS_FILE = "/invalid/path/events.json";
        JsonDataManager.PARTICIPANTS_FILE = "/invalid/path/participants.json";

        // Add some test data
        GestionEvenements.getEvenements().put("event1", testEvent);

        // Should handle the IOException gracefully (currently just prints to console)
        assertDoesNotThrow(() -> JsonDataManager.saveEvents());
    }

    @Test
    void testFileContentFormat() throws IOException {
        // Add test data
        Map<String, Evenement> events = new HashMap<>();
        events.put("event1", testEvent);
        Map<Participant, Evenement> participants = new HashMap<>();
        participants.put(testParticipant, testEvent);

        // Save to files
        JsonDataManager.saveEvents();

        // Verify file content using ObjectMapper directly
        ObjectMapper mapper = new ObjectMapper();
        
        // Check events file
        Map<String, Evenement> loadedEvents = mapper.readValue(
            new File(JsonDataManager.EVENEMENTS_FILE),
            new TypeReference<Map<String, Evenement>>() {}
        );
        assertEquals(events, loadedEvents);

        // Check participants file
        Map<Participant, Evenement> loadedParticipants = mapper.readValue(
            new File(JsonDataManager.PARTICIPANTS_FILE),
            new TypeReference<Map<Participant, Evenement>>() {}
        );
        assertEquals(participants, loadedParticipants);
    }
}