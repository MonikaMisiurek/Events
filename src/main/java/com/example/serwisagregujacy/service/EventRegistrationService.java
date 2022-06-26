package com.example.serwisagregujacy.service;

import com.example.serwisagregujacy.dto.EventDTO;
import com.example.serwisagregujacy.model.Events;
import com.example.serwisagregujacy.repository.EventsRepository;
import org.springframework.stereotype.Service;

@Service
public class EventRegistrationService {

    private final EventsRepository eventsRepository;

    public EventRegistrationService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public void addEvents(EventDTO event){

        Events events = Events.from(event);

        events.toDto();

        eventsRepository.save(events);
    }
}

