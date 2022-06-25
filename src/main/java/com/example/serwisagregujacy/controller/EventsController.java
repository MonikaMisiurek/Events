package com.example.serwisagregujacy.controller;

import com.example.serwisagregujacy.model.Events;
import com.example.serwisagregujacy.serwice.EventsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EventsController {

    private final EventsService eventsService;

    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping("/events")
    public String getEventss(Model model) {
        List<Events> item = eventsService.getEvents();
        model.addAttribute("items", item);
        return "events/events";
    }

    @PostMapping("/addNewEvents")
    public RedirectView postAddNewEvents(@Valid Events events) {
        eventsService.addNewEvents(events);
        return new RedirectView("/events");
    }

    @PostMapping("/editEvents/{id}")
    public RedirectView postEditEvents(@Valid Events events, @PathVariable Long id) {
        eventsService.editEvents (events);
        return new RedirectView("/events");
    }

    @PostMapping ("deleteEvents/ {id}")
    public RedirectView postDeleteEvents (Events events, @PathVariable Long id){
        eventsService.deleteEvents(events);
        return new RedirectView("/events");
    }

    // sortowanie na przyszłe i przeszłe

}
