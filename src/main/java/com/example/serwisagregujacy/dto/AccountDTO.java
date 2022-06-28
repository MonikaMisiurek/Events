package com.example.serwisagregujacy.dto;

import com.example.serwisagregujacy.model.Events;
import com.example.serwisagregujacy.model.UserLevel;
import lombok.Value;

import java.util.Set;

@Value
public class AccountDTO {
    Long id;
    String name;
    String email;
    UserLevel role;
    Set<Events> enrolledEvents;

}
