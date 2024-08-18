package org.example.socialmedia.service;

import lombok.RequiredArgsConstructor;
import org.example.socialmedia.entity.Post;
import org.example.socialmedia.entity.User;
import org.example.socialmedia.repository.PostRepository;
import org.example.socialmedia.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;

    public Post createPost(Long userId, Post post) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            post.setAuthor(user);
            return postRepository.save(post);
        }
        return null;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
}