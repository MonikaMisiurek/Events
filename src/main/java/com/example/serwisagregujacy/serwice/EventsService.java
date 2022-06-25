package com.example.serwisagregujacy.serwice;

import com.example.serwisagregujacy.model.Events;
import com.example.serwisagregujacy.repository.EventsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {

    private final EventsRepository eventsRepository;


    public EventsService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public List<Events> getEvents(){
        return eventsRepository.findAll();
    }

    public void addNewEvents (Events events){
        eventsRepository.save(events);
    }

    public void editEvents (Events events){
        eventsRepository.save(events);
    }

    public void deleteEvents (Events events){
        eventsRepository.delete(events);
    }




}
