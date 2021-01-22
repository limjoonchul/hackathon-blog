package com.fastcampus.blog.controller;

import com.fastcampus.blog.model.Post;
import com.fastcampus.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return  postService.getPosts();
    }

}
