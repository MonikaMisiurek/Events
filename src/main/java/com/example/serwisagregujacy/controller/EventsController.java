package com.example.serwisagregujacy.controller;

import com.example.serwisagregujacy.model.Events;
import com.example.serwisagregujacy.service.EventsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/events")
public class EventsController {

    private final EventsService eventsService;

    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping
    public String allEvents(Model model) {
        List<Events> item = eventsService.getEvents();
        model.addAttribute("items", item);
        return "events/events";
    }
//    @GetMapping("/addEvents") //tu dodane mn
//    public String getAddEvents() {
//        return ("/events/add");
//    }

    @PostMapping
    public RedirectView newEvent(@Valid Events events) {
        eventsService.addNewEvents(events);
        return new RedirectView("/events/add"); //zmieniony url
    }
    @GetMapping("/{id}") //tu dodane mn
    public String editEvent(@PathVariable Long id, Model model){
        Events events = eventsService.getEventsById(id);
        model.addAttribute("events", events);
        return ("/eventpage");
    }
    @PutMapping("/{id}")
    public RedirectView modifyEvent(@Valid Events events, @PathVariable Long id) {
        eventsService.editEvents (events);
        return new RedirectView("/eventpage"); //zmieniony url
    }

    @DeleteMapping("/{id}")
    public RedirectView deleteEvent (Events events, @PathVariable Long id){
        eventsService.deleteEvents(events);
        return new RedirectView("/events");
    }

    // sortowanie na przyszłe i przeszłe

}
