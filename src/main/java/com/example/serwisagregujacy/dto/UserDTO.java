package com.example.serwisagregujacy.dto;

import com.example.serwisagregujacy.model.Account;
import com.example.serwisagregujacy.model.Events;
import com.example.serwisagregujacy.model.UserLevel;
import lombok.Value;

import java.util.Set;

@Value
public class UserDTO {
    Long id;
    String name;
    String password;
    String email;
    UserLevel role;
    Set<Events> events;
}
