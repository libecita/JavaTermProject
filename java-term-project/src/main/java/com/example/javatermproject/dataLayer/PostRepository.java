package com.example.javatermproject.dataLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post getPostByPostIdentifier(String postId);



    List<Post> findAllPostsByUsername(String username);
}
