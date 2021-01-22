package com.fastcampus.blog.controller;

import com.fastcampus.blog.dto.PostDto;
import com.fastcampus.blog.model.Post;
import com.fastcampus.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/api/post/{id}")
    public Post getPost(@PathVariable Long id) {
        return  postService.getPost(id);
    }

    @PostMapping("/api/writePost")
    public Post writePost(@RequestBody @Valid PostDto dto) {
        return  postService.writePost(dto);
    }

    @PostMapping("/api/updatePost")
    public Post updatePost(@RequestBody @Valid PostDto dto) {
        return  postService.updatePost(dto);
    }

    @GetMapping("/api/deletePost/{id}")
    public Post updatePost(@PathVariable Long id) {
        return  postService.deletePost(id);
    }

}
