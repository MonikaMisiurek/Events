package com.example.serwisagregujacy.dto;

import lombok.Value;

import java.util.Date;

@Value
public class EventDTO {
    Long id;
    String name;
    Date data;
    String description;
}
