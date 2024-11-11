package com.example.javatermproject.dataLayer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="posts")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String postIdentifier;
    private String datePosted;
    private String description;
    private String title;

    @Column(name = "username")
    private String username;
}
