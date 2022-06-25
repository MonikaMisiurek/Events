package com.example.serwisagregujacy.serwice;

import com.example.serwisagregujacy.model.Events;
import com.example.serwisagregujacy.model.User;
import com.example.serwisagregujacy.repository.EventsRepository;
import com.example.serwisagregujacy.repository.UserRepository;
import jdk.jfr.Event;
import org.springframework.stereotype.Service;

@Service
public class EventRegistrationService {

    private final EventsRepository eventsRepository;

    public EventRegistrationService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }
    public void addEvents(Events events){
        eventsRepository.save(events);
    }
}

