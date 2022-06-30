package com.example.serwisagregujacy.controller;

import com.example.serwisagregujacy.model.Contact;
import com.example.serwisagregujacy.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ContactController {

    public final ContactService contactService;


    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String allContacts() {
        return ("/contact");
    }

    @PostMapping("/contact")
    public RedirectView addContact(Contact contact) {
        contactService.addNewContact(contact);
        return new RedirectView("/contact");
    }

    @PutMapping("contact/{id}")
    public RedirectView modifyContact(Contact contact, @PathVariable Long id) {
        contactService.editContact(contact);
        return new RedirectView("/contact");
    }

    @DeleteMapping("contact/{id}")
    public RedirectView deleteContact (Contact contact, @PathVariable Long id){
        contactService.deleteContact(contact);
        return new RedirectView("/contact");
    }

}
