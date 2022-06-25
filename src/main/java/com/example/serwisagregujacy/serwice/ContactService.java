package com.example.serwisagregujacy.serwice;

import com.example.serwisagregujacy.model.Contact;
import com.example.serwisagregujacy.repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    public void addNewContact (Contact contact){
        contactRepository.save(contact);
    }

    public void editContact(Contact contact){
        contactRepository.save(contact);
    }

    public void deleteContact(Contact contact){
        contactRepository.delete(contact);
    }



}
