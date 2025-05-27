package com.example.eventmanager.usefulclasses.serializers;

import com.example.eventmanager.usefulclasses.Participant;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class ParticipantKeyModule extends SimpleModule {
    public ParticipantKeyModule() {
        addKeyDeserializer(Participant.class, new ParticipantKeyDeserializer());
        addKeySerializer(Participant.class, new ParticipantKeySerializer());
    }

    
}