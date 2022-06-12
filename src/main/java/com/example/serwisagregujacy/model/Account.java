package com.example.serwisagregujacy.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
@Entity
public class Account extends User {



    @OneToOne()
    private User id;

}
