package org.example.socialmedia.service;

import org.example.socialmedia.entity.Like;
import org.example.socialmedia.entity.Post;
import org.example.socialmedia.entity.User;
import org.example.socialmedia.repository.LikeRepository;
import org.example.socialmedia.repository.PostRepository;
import org.example.socialmedia.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LikeServiceTest {

    @Mock
    private LikeRepository likeRepository;

    @Mock
    private PostRepository postRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private LikeService likeService;

    public LikeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLikePost() {
        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");

        Post post = new Post();
        post.setId(1L);
        post.setTitle("Test Title");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(likeRepository.save(any(Like.class))).thenReturn(new Like());

        Like like = likeService.likePost(1L, 1L);

        assertNotNull(like);
    }

    @Test
    public void testGetAllLikes() {
        Like like = new Like();

        when(likeRepository.findAll()).thenReturn(Collections.singletonList(like));

        List<Like> likes = likeService.getAllLikes();

        assertNotNull(likes);
        assertFalse(likes.isEmpty());
    }
}