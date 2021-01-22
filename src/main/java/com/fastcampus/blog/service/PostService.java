package com.fastcampus.blog.service;

import com.fastcampus.blog.dto.PostDto;
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

    public Post writePost(PostDto postDto) {

        Post post = new Post();

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        postRepository.save(post);

        return post;
    }

    public Post updatePost(PostDto postDto) {

        Post post = postRepository.findPostById(postDto.getId()).orElse(Post.emptyObject());

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        postRepository.save(post);

        return post;
    }

    public void deletePost(Long id) {

        Post post = postRepository.findPostById(id).orElse(Post.emptyObject());

        post.setDeleted(true);

        postRepository.save(post);
    }


}
