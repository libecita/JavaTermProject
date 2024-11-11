package com.example.javatermproject.presentationLayer;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class UserRequestModel {

    private String userIdentifier;

    private String lastName;

    private String firstName;

    private String emailAddress;

    private String username;

    private String password;

}