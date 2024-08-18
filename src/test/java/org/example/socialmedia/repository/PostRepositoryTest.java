package org.example.socialmedia.repository;

import org.example.socialmedia.entity.Post;
import org.example.socialmedia.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSavePost() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        userRepository.save(user);

        Post post = new Post();
        post.setTitle("Test Title");
        post.setBody("Test Body");
        post.setAuthor(user);

        Post savedPost = postRepository.save(post);

        assertNotNull(savedPost);
        assertEquals("Test Title", savedPost.getTitle());
    }

    @Test
    public void testFindPostById() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        userRepository.save(user);

        Post post = new Post();
        post.setTitle("Test Title");
        post.setBody("Test Body");
        post.setAuthor(user);
        Post savedPost = postRepository.save(post);

        Post foundPost = postRepository.findById(savedPost.getId()).orElse(null);

        assertNotNull(foundPost);
        assertEquals("Test Title", foundPost.getTitle());
    }
}