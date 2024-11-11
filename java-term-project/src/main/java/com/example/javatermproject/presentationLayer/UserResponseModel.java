package com.example.javatermproject.presentationLayer;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class UserResponseModel extends RepresentationModel<UserResponseModel> {

    private String userIdentifier;

    private String lastName;
    private String firstName;
    private String emailAddress;
    private String username;

    private String relationshipStatus;
    private String dateOfBirth;
    private String dateJoined;
}