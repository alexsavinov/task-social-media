package org.example.socialmedia.repository;

import org.example.socialmedia.entity.Like;
import org.example.socialmedia.entity.Post;
import org.example.socialmedia.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class LikeRepositoryTest {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    public void testSaveLike() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        userRepository.save(user);

        Post post = new Post();
        post.setTitle("Test Title");
        post.setBody("Test Body");
        post.setAuthor(user);
        postRepository.save(post);

        Like like = new Like();
        like.setUser(user);
        like.setPost(post);

        Like savedLike = likeRepository.save(like);

        assertNotNull(savedLike);
    }

    @Test
    public void testFindLikeById() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        userRepository.save(user);

        Post post = new Post();
        post.setTitle("Test Title");
        post.setBody("Test Body");
        post.setAuthor(user);
        postRepository.save(post);

        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        Like savedLike = likeRepository.save(like);

        Like foundLike = likeRepository.findById(savedLike.getId()).orElse(null);

        assertNotNull(foundLike);
    }
}