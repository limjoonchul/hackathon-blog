package com.fastcampus.blog.service;

import com.fastcampus.blog.model.Post;
import com.fastcampus.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    public Post getPost(Long id) {
        return postRepository.findPostById(id).orElse(Post.emptyObject());
    }

//    public Post writePost(PostDto) {
//
//    }

}
