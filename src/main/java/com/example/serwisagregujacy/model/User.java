package com.example.serwisagregujacy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;
    //todo tu zrobić walidacje na @
    @Column(name = "EMAIL")
    private String email;


    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Events> enrolledEvent;
    /*@OneToOne()
    private Account account;*/
}