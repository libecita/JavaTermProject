package com.example.javatermproject.presentationLayer;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class PostResponseModel extends RepresentationModel<PostResponseModel> {

    private String postIdentifier;
    private String datePosted;
    private String description;
    private String title;
    private String userIdentifier;
    private String picture;
}