package com.example.serwisagregujacy.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account extends User {


    @OneToOne()
    private User id;
    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private UserLevel role;


}