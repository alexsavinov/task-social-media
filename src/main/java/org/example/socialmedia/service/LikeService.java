// src/main/java/org/example/socialmedia/service/LikeService.java
package org.example.socialmedia.service;

import lombok.RequiredArgsConstructor;
import org.example.socialmedia.entity.Like;
import org.example.socialmedia.entity.Post;
import org.example.socialmedia.entity.User;
import org.example.socialmedia.repository.LikeRepository;
import org.example.socialmedia.repository.PostRepository;
import org.example.socialmedia.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {

    private LikeRepository likeRepository;
    private PostRepository postRepository;
    private UserRepository userRepository;

    public Like likePost(Long userId, Long postId) {
        User user = userRepository.findById(userId).orElse(null);
        Post post = postRepository.findById(postId).orElse(null);
        if (user != null && post != null) {
            Like like = new Like();
            like.setUser(user);
            like.setPost(post);
            return likeRepository.save(like);
        }
        return null;
    }

    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }
}