package com.example.serwisagregujacy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contact {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PHONE")
    private long phone;
    //TODO validation email
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ADDRESS")
    private String address;




}
