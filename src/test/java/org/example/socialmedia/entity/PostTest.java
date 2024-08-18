package org.example.socialmedia.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PostTest {

    @Test
    public void testPostCreation() {
        Post post = new Post();
        post.setTitle("Test Title");
        post.setBody("Test Body");

        assertEquals("Test Title", post.getTitle());
        assertEquals("Test Body", post.getBody());
    }

    @Test
    public void testPostAuthor() {
        Post post = new Post();
        User user = new User();
        user.setUsername("testuser");

        post.setAuthor(user);

        assertEquals(user, post.getAuthor());
    }

    @Test
    public void testPostLikes() {
        Post post = new Post();
        Like like = new Like();

        post.getLikes().add(like);

        assertTrue(post.getLikes().contains(like));
    }
}