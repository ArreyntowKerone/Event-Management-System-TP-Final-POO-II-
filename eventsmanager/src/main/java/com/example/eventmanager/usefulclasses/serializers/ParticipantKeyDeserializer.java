package com.example.eventmanager.usefulclasses.serializers;

import com.example.eventmanager.usefulclasses.Participant;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

import java.io.IOException;

public class ParticipantKeyDeserializer extends KeyDeserializer {
    @Override
    public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException {
        String[] parts = key.split(":");
        return new Participant(parts[0], parts[1]); // Assume constructor or parsing logic based on how you serialized it
    }
}
