package com.example.serwisagregujacy.dto;

import com.example.serwisagregujacy.model.Events;
import lombok.Value;

import java.util.Set;

@Value
public class UserDTO {
    Long id;
    String name;
    String password;
    String email;
    Set<Events> enrolledEvent;
}
