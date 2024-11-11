package com.example.javatermproject.presentationLayer;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class LikeRequestModel {

    private int id;

    private String likeIdentifier;

}