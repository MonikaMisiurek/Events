package com.example.serwisagregujacy.dto;

import com.example.serwisagregujacy.model.User;
import lombok.Value;

import java.util.Date;
import java.util.Set;

@Value
public class EventDTO {
    Long id;
    String name;
    Date data;
    String description;
    Set<User> enrolledUser;
}
