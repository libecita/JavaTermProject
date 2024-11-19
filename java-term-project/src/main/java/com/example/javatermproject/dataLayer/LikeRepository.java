package com.example.javatermproject.dataLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    List<Like> findAll();

    Like getLikeByLikeIdentifier(String likeId);

//    User findUserByUsername(String username);
}
