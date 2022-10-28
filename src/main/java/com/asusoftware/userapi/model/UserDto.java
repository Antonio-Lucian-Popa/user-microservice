package com.asusoftware.userapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UserDto {

    private UUID id;
    private UUID profileImageId; // il generam automat in momentul inregistrarii, dupa care la poza ii bagam acel id
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private String phoneNumber;
}
