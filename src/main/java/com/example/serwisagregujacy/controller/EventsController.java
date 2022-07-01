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
    public String getEvents(Model model) {
        List<Events> item = eventsService.getEvents();
        model.addAttribute("items", item);
        return ("events/events");
    }
    @PostMapping
    public RedirectView newEvent(@Valid Events events) {
        eventsService.addNewEvents(events);
        return new RedirectView("/events/add");
    } // to ma być podpięte pod przycisk submit form

    @GetMapping("/{id}")
    public String getEventsById(@PathVariable Long id){
        eventsService.getEventsById(id);
    return "eventPage";
    }

// DODAWANIE EVENTU W REGISTRATION:
//@PostMapping("/eventsRegistration")
//public RedirectView postAddEvents(@PathVariable Events events){
//    eventRegistrationService.addEvents(events);
//    return new RedirectView("/events/eventsRegistration");
//}
//    }
//    @GetMapping("/{id}")
//    public String editEvent(@PathVariable Long id, Model model){
//        Events events = eventsService.getEventsById(id);
//        model.addAttribute("events", events);
//        return ("/eventPage");
//    }
//    @PutMapping("/{id}")
//    public RedirectView modifyEvent(@Valid Events events, @PathVariable Long id) {
//        eventsService.editEvents (events);
//        return new RedirectView("/eventPage");
//    }
//
//    @DeleteMapping("/{id}")
//    public RedirectView deleteEvent (Events events, @PathVariable Long id){
//        eventsService.deleteEvents(events);
//        return new RedirectView("/events");
//    }


}
