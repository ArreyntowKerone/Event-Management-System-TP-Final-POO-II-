package com.example.eventmanager.usefulclasses.serializers;

import com.example.eventmanager.usefulclasses.Participant;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class ParticipantKeyModule extends SimpleModule {
    public ParticipantKeyModule() {
        addKeySerializer(Participant.class, new ParticipantKeySerializer());
        addKeyDeserializer(Participant.class, new ParticipantKeyDeserializer());
    }
}
