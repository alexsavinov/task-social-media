package org.example.socialmedia.service;

import org.example.socialmedia.entity.Post;
import org.example.socialmedia.entity.User;
import org.example.socialmedia.repository.PostRepository;
import org.example.socialmedia.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PostService postService;

    public PostServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePost() {
        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");

        Post post = new Post();
        post.setTitle("Test Title");
        post.setBody("Test Body");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(postRepository.save(any(Post.class))).thenReturn(post);

        Post createdPost = postService.createPost(1L, post);

        assertNotNull(createdPost);
        assertEquals("Test Title", createdPost.getTitle());
    }

    @Test
    public void testGetPostById() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Test Title");

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));

        Post foundPost = postService.getPostById(1L);

        assertNotNull(foundPost);
        assertEquals("Test Title", foundPost.getTitle());
    }
}