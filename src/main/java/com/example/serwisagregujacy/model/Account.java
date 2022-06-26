package com.example.serwisagregujacy.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.example.serwisagregujacy.dto.AccountDTO;
import com.example.serwisagregujacy.dto.UserDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account extends User {

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private UserLevel role;

    public Account(UserLevel role) {
        this.role = role;
    }

    public static Account from(AccountDTO account){
        return new Account(account.getId(), account.getName(), account.getEmail(), account.getRole(), account.getEnrolledEvents());

    }
    public AccountDTO toDto() {
        return new AccountDTO(getId(), getName(), getEmail(), getRole(), getEnrolledEvent());
    }





}