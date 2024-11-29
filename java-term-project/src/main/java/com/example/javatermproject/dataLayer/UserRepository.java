package com.example.javatermproject.dataLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User, String> {

    User getUserByUserIdentifier(String userId);

    Set<Post> findPostsByUsername(String username);
}
