package com.example.serwisagregujacy.controller;

import com.example.serwisagregujacy.dto.EventDTO;
import com.example.serwisagregujacy.service.EventRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class EventRegistrationController {

    private final EventRegistrationService eventRegistrationService;

    public EventRegistrationController(EventRegistrationService eventRegistrationService) {
        this.eventRegistrationService = eventRegistrationService;
    }

    @GetMapping("/eventsRegistration")
    public String getEventRegistration() {
        return ("events/eventsRegistration");
    }

    @PostMapping("/eventsRegistration")
    public RedirectView postAddEvents(@PathVariable EventDTO events){
        eventRegistrationService.addEvents(events);
        return new RedirectView("/events/eventsRegistration");
    }
}
