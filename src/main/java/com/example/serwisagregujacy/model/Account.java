package com.example.serwisagregujacy.model;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

public class Account extends User {

    @OneToOne()
    private User id;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private UserLevel role;


}