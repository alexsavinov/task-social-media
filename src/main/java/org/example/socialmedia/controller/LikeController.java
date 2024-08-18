package org.example.socialmedia.controller;

import lombok.RequiredArgsConstructor;
import org.example.socialmedia.entity.Like;
import org.example.socialmedia.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {

    private LikeService likeService;

    @PostMapping("/{userId}/{postId}")
    public Like likePost(@PathVariable Long userId, @PathVariable Long postId) {
        return likeService.likePost(userId, postId);
    }

    @GetMapping
    public List<Like> getAllLikes() {
        return likeService.getAllLikes();
    }
}