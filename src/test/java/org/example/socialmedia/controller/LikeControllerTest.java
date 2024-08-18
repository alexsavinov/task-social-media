package org.example.socialmedia.controller;

import org.example.socialmedia.entity.Like;
import org.example.socialmedia.service.LikeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

public class LikeControllerTest {

    @Mock
    private LikeService likeService;

    @InjectMocks
    private LikeController likeController;

    private MockMvc mockMvc;

    public LikeControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(likeController).build();
    }

    @Test
    public void testLikePost() throws Exception {
        Like like = new Like();

        when(likeService.likePost(anyLong(), anyLong())).thenReturn(like);

        mockMvc.perform(post("/likes/1/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testGetAllLikes() throws Exception {
        Like like = new Like();

        when(likeService.getAllLikes()).thenReturn(Collections.singletonList(like));

        mockMvc.perform(get("/likes"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}