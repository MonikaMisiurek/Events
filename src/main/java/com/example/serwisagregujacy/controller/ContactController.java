package com.example.serwisagregujacy.controller;

import com.example.serwisagregujacy.model.Contact;
import com.example.serwisagregujacy.serwice.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ContactController {

    public final ContactService contactService;


    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String getContact() {
        return "contact/contact";
    }

    @PostMapping("/addNewContact")
    public RedirectView postAddNewContact(Contact contact) {
        contactService.addNewContact(contact);
        return new RedirectView("/contact");
    }

    @PostMapping("/editContact/{id}")
    public RedirectView postEditContact(Contact contact, @PathVariable Long id) {
        contactService.editContact(contact);
        return new RedirectView("/contact");
    }

    @PostMapping("delete/deleteContact/{id}")
    public RedirectView postDeleteContact (Contact contact, @PathVariable Long id){
        contactService.deleteContact(contact);
        return new RedirectView("/contact");
    }

}
