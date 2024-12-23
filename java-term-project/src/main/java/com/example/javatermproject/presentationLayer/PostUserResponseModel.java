package com.example.javatermproject.presentationLayer;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class PostUserResponseModel extends RepresentationModel<PostUserResponseModel>{

    private String userIdentifier;
    private String postIdentifier;
    private String id;

}