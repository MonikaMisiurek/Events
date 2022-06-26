package com.example.serwisagregujacy.controller;

import com.example.serwisagregujacy.dto.EventDTO;
import com.example.serwisagregujacy.service.EventRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/events")
public class EventRegistrationController {

    private final EventRegistrationService eventRegistrationService;

    public EventRegistrationController(EventRegistrationService eventRegistrationService) {
        this.eventRegistrationService = eventRegistrationService;
    }

    @GetMapping
    public String EventRegistration() {
        return ("/eventsRegistration");
    }

    @PostMapping
    public RedirectView addEvents(@PathVariable EventDTO events){
        eventRegistrationService.addEvents(events);
        return new RedirectView("/eventsRegistration");
    }
}
