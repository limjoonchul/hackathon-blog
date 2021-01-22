package com.fastcampus.blog.service;

import com.fastcampus.blog.dto.PostDto;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    void getPostTest() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("getPostTestTitle");

        when(postRepository.findPostById(1L)).thenReturn(java.util.Optional.of(post));

        Post result = postService.getPost(1L);

        assertThat(result.getTitle()).isEqualTo("getPostTestTitle");

    }

    @Test
    void getPostTestIfNull() {
        assertThrows(RuntimeException.class, () -> postService.getPost(null));
    }

    @Test
    void updatePostTest() {
        PostDto postDto = new PostDto();
        postDto.setId(1L);

        postService.updatePost(postDto);

        verify(postRepository, times(1)).findPostById(1L);
        verify(postRepository, times(1)).save(any(Post.class));

    }



    private List<Post> mockPosts() {
        List<Post> posts = new ArrayList<>();
        Post post = new Post();
        post.setTitle("mockTestTitle");

        posts.add(post);

        return posts;
    }


}