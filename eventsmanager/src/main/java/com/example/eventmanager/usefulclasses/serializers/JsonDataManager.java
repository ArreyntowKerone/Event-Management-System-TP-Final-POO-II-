package com.example.eventmanager.usefulclasses.serializers;

//import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.example.eventmanager.usefulclasses.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonDataManager {
    public static String EVENEMENTS_FILE = "data/events.json";
    public static String PARTICIPANTS_FILE = "data/participants.json";

    private static final ObjectMapper objectMapper = createConfiguredMapper();

    private static ObjectMapper createConfiguredMapper() {
        ObjectMapper mapper = new ObjectMapper();
    
        // Register modules
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new ParticipantKeyModule()); //Register your custom serializer/deserializer here
    
        // Pretty print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        //mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    
        // Optionally: handle polymorphism if you're using @JsonTypeInfo in Evenement
        //mapper.activateDefaultTyping(
        //    mapper.getPolymorphicTypeValidator(),
        //    ObjectMapper.DefaultTyping.NON_FINAL,
        //    JsonTypeInfo.As.PROPERTY
        //);
    
        return mapper;
    }
    

    public static void saveEvents() {
        try {
            ensureDataDirectoryExists();
            
            // Save with type information
            objectMapper.writeValue(
                new File(EVENEMENTS_FILE),
                GestionEvenements.getInstance().getEvenements()
            );
            
            objectMapper.writeValue(
                new File(PARTICIPANTS_FILE),
                GestionEvenements.getInstance().getPersonnes()
            );
            
        } catch (IOException e) {
            handleSerializationError("Error saving data", e);
        }
    }

    public static void loadEvents() {
        try {
            // Load events with type information
            Map<String, Evenement> evenements = loadFromFile(
            EVENEMENTS_FILE,
            new TypeReference<Map<String, Evenement>>() {}
        );
            Map<Participant, Evenement> participants = loadFromFile(
                PARTICIPANTS_FILE,
                new TypeReference<Map<Participant, Evenement>>() {}
            );
            
            if (evenements != null) {
                GestionEvenements.getInstance().getEvenements().clear();
                GestionEvenements.getInstance().getEvenements().putAll(evenements);
            }
            
            if (participants != null) {
                GestionEvenements.getInstance().getPersonnes().clear();
                GestionEvenements.getInstance().getPersonnes().putAll(participants);
            }
            
        } catch (IOException e) {
            handleSerializationError("Error loading data", e);
        }
    }

    private static <T> T loadFromFile(String path, TypeReference<T> typeRef) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        return objectMapper.readValue(file, typeRef);
    }

    private static void ensureDataDirectoryExists() {
        new File("data").mkdirs();
    }

    private static void handleSerializationError(String message, Exception e) {
        System.err.println(message + ": " + e.getMessage());
        System.out.println(e.getMessage());
        // Consider adding application-specific error handling here
    }
}