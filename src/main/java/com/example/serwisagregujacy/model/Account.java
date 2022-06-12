package com.example.serwisagregujacy.model;

import javax.persistence.OneToOne;

public class Account extends User {

    private Events event;

    @OneToOne()
    private User id;

}
