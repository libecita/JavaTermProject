package com.example.javatermproject.presentationLayer;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class LikeRequestModel {

    private String likeIdentifier;
    private String username;
    private String postIdentifier;

}