package com.fastcampus.blog.repository;


import com.fastcampus.blog.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    @Test
    void findPostById() {
        Post post = givenPost(1L, "PostTitle", "PostContent");
        postRepository.save(post);

        Post result = postRepository.findPostById(1L).get();

        assertThat(result.getTitle()).isEqualTo("PostTitle");
        assertThat(result.getContent()).isEqualTo("PostContent");
    }

    private Post givenPost(Long id, String title, String content){
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);

        return post;
    }

}