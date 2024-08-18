package org.example.socialmedia.service;

import lombok.RequiredArgsConstructor;
import org.example.socialmedia.entity.User;
import org.example.socialmedia.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void followUser(Long userId, Long followerId) {
        User user = getUserById(userId);
        User follower = getUserById(followerId);
        if (user != null && follower != null) {
            user.getFollowers().add(follower);
            userRepository.save(user);
        }
    }
}