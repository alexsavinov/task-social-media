package org.example.socialmedia.repository;

import org.example.socialmedia.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}