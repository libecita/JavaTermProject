package com.example.javatermproject.dataLayer;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userIdentifier")
    private String userIdentifier;

    private String lastName;
    private String firstName;
    private String emailAddress;
    private String username;

    private String relationshipStatus;
    private String dateOfBirth;
    private String dateJoined;
    private String password;

    @OneToMany(mappedBy = "username")
    private Set<Post> posts;
}
