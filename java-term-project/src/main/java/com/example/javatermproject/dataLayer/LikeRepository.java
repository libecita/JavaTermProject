package com.example.javatermproject.dataLayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    List<Like> findAllLikes();

    Like getLikeById(Integer likeId);
}
