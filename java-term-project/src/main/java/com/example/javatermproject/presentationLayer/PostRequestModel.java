package com.example.javatermproject.presentationLayer;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class PostRequestModel {

    private String postIdentifier;
    private String datePosted;
    private String description;
    private String title;
    private String username;
}