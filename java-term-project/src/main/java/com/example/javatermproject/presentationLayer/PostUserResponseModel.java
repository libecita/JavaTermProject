package com.example.javatermproject.presentationLayer;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class PostUserResponseModel extends RepresentationalModel<PostUserResponseModel>{
    private String post;
    private String id;
    private String likeId;
    private String like;
}