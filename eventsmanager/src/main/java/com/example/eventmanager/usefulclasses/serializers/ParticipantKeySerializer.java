package com.example.eventmanager.usefulclasses.serializers;

import com.example.eventmanager.usefulclasses.Participant;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializer;

import java.io.IOException;

public class ParticipantKeySerializer extends JsonSerializer<Participant> {
    @Override
    public void serialize(Participant key, com.fasterxml.jackson.core.JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeFieldName(key.getId()); // or use a toString() or custom string representation
    }
}
