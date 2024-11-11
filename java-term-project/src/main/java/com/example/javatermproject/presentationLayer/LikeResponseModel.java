package com.example.javatermproject.presentationLayer;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class LikeResponseModel extends RepresentationModel<LikeResponseModel>{

    private String likeIdentifier;
    private String username;
    private String postIdentifier;
}