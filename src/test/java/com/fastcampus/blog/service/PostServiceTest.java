package com.fastcampus.blog.service;

import com.fastcampus.blog.model.Post;
import com.fastcampus.blog.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Test
    void getPostsTest(){
        when(postRepository.findAll()).thenReturn(mockPosts());

        List<Post> result = postService.getPosts();

        System.out.println(">>>" + result);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getTitle()).isEqualTo("mockTestTitle");

    }

    private List<Post> mockPosts() {
        List<Post> posts = new ArrayList<>();
        Post post = new Post();
        post.setTitle("mockTestTitle");

        posts.add(post);

        return posts;
    }


}