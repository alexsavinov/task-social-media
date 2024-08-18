package org.example.socialmedia.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LikeTest {

    @Test
    public void testLikeCreation() {
        Like like = new Like();

        assertNotNull(like);
    }

    @Test
    public void testLikeUser() {
        Like like = new Like();
        User user = new User();
        user.setUsername("testuser");

        like.setUser(user);

        assertEquals(user, like.getUser());
    }

    @Test
    public void testLikePost() {
        Like like = new Like();
        Post post = new Post();
        post.setTitle("Test Title");

        like.setPost(post);

        assertEquals(post, like.getPost());
    }
}