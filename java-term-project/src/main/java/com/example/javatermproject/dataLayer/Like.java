package com.example.javatermproject.dataLayer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="likes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "likeIdentifier")
    private String likeIdentifier;

//    @Column(name="username")
//    private String username;
//
//    @Column(name="postIdentifier")
//    private String postIdentifier;

    @OneToMany(mappedBy = "username")
    private Set<User> users;

    @OneToMany(mappedBy = "postIdentifier")
    private Set<Post> posts;

}
