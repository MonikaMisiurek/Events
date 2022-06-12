package com.example.serwisagregujacy.model;

import javax.persistence.*;

@Entity
public class Account extends User {



    @OneToOne()
    private User id;

}
