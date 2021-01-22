package com.fastcampus.blog.controller;

import com.fastcampus.blog.dto.PostDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PostControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void before(WebApplicationContext wac) {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @Test
    void getPostsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/posts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].title").value("title"))
                .andExpect(jsonPath("$.[0].content").value("content"));
    }

    @Test
    void getPostTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/post/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("title"))
                .andExpect(jsonPath("$.content").value("content"));
    }

    @Test
    void writePostTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/writePost")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(
                        objectMapper.writeValueAsString(
                                new PostDto(2L, "writeTitle", "writeContent", null, null)
                        )

                ))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("writeTitle"))
                .andExpect(jsonPath("$.content").value("writeContent"));

    }

    @Test
    void updatePostTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/updatePost")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(
                        objectMapper.writeValueAsString(
                                new PostDto(2L, "updateTitle", "updateContent", null, null)
                        )

                ))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("updateTitle"))
                .andExpect(jsonPath("$.content").value("updateContent"));
    }
}