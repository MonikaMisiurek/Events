package com.example.serwisagregujacy.service;

import com.example.serwisagregujacy.dto.EventDTO;
import com.example.serwisagregujacy.model.Events;
import com.example.serwisagregujacy.repository.EventsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventsService {

    private final EventsRepository eventsRepository;

    public EventsService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public List<Events> getEvents(){
        var sort = Sort.by(Sort.Direction.DESC, "data");
        return eventsRepository.findAll(sort);
    }
    public List<Events> getEvents(Date begin, Date end){
        return eventsRepository.findByDataBetweenOrderByDataDesc(begin, end);
    }

    public void addNewEvents (Events events){
        eventsRepository.save(events);
    } //jak ona się ma to tworzenia evetntsDTO?

//    public void addEvents(EventDTO event){ //z registration Service
//        Events events = Events.from(event);
//        events.toDto();
//        eventsRepository.save(events);
//    }

    public Events getEventsById(Long id) {
        return eventsRepository.findById(id).orElse(null); } //po kliknięciu na konkretny event
    public void editEvents (Events events){
        eventsRepository.save(events);
    }

    public void deleteEvents (Events events){// czy ta metoda wie który event usunąć czy nie trzeba dodać findBy...
        eventsRepository.delete(events);
    }

}
