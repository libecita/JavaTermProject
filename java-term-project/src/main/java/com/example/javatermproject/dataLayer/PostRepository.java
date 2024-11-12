package com.example.javatermproject.dataLayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post getPostByPostIdentifier(String postId);
}
