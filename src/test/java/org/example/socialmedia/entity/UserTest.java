package org.example.socialmedia.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testUserCreation() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");

        assertEquals("testuser", user.getUsername());
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testUserFollowers() {
        User user = new User();
        User follower = new User();
        follower.setUsername("follower");

        user.getFollowers().add(follower);

        assertTrue(user.getFollowers().contains(follower));
    }

    @Test
    public void testUserPosts() {
        User user = new User();
        Post post = new Post();
        post.setTitle("Test Title");
        post.setBody("Test Body");
        post.setAuthor(user);

        user.getPosts().add(post);

        assertTrue(user.getPosts().contains(post));
    }
}