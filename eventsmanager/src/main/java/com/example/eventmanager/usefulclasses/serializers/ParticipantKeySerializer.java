package com.example.eventmanager.usefulclasses.serializers;

import com.example.eventmanager.usefulclasses.Participant;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

public class ParticipantKeySerializer extends JsonSerializer<Participant> {
    @Override
    public void serialize(Participant key, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String compositeKey = key.getId() + "|" + key.getNom() + "|" + key.getEmail();
        gen.writeFieldName(compositeKey);
    }
}
