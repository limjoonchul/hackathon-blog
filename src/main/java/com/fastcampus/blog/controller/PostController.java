package com.fastcampus.blog.controller;

import com.fastcampus.blog.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    @GetMapping("/api/posts")
    public List<Post> getPosts() {

        List<Post> posts = new ArrayList<>();

        return posts;
    }

}
