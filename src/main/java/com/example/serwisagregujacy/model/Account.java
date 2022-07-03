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
//@AllArgsConstructor //jest ok, gdy usuwam konstruktor w tej klasie, bo to właściwie zdublowanie konstruktora
@Getter
@Setter
public class Account extends User {


    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private UserLevel role = UserLevel.USER;
    public Account(Long id, String name, String email, UserLevel role, Set<Events> events) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.events = events;
    }
    //po stworzeniu tego konstruktora przestała sie świecić na czerwono metoda from. Jakby ta klasa nie miała dostępu do konstruktora z user

//    public Account(UserLevel role) {
//        this.role = role;}


    public static Account from(AccountDTO account){
        return new Account(account.getId(), account.getName(), account.getEmail(), account.getRole(), account.getEvents());

    }
    public AccountDTO toDto2() {
        return new AccountDTO(getId(), getName(), getEmail(), getRole(), getEvents());
    }

}
