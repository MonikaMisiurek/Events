package com.example.serwisagregujacy.dto;

import lombok.Value;

@Value
public class UserDTO {
    Long id;
    String name;
    String password;
    String email;
}
