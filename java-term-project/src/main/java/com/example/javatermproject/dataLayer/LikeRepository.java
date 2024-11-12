package com.example.javatermproject.dataLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    List<Like> findAll();

    Like getLikeById(Integer likeId);

    Like getLikeByLikeIdentifier(String likeId);
}
