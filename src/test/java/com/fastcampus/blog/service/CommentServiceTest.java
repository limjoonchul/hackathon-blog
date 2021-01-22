package com.fastcampus.blog.service;

import com.fastcampus.blog.dto.CommentDto;
import com.fastcampus.blog.model.Comment;
import com.fastcampus.blog.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {
    @InjectMocks
    private CommentService commentService;

    @Mock
    private CommentRepository commentRepository;

    @Test
    void getCommentById(){
        when(commentRepository.findById(1L)).thenReturn(java.util.Optional.of(new Comment(1L, "안녕하세요", null, null, false)));

        Comment getComment = commentService.getCommentById(1L);

        assertThat(getComment.getContent()).isEqualTo("안녕하세요");
    }

    @Test
    void modifyComment(){
        CommentDto commentDto = new CommentDto();
        commentDto.setContent("반가워요");

        commentService.saveComment(commentDto);

        verify(commentRepository, times(1)).save(any(Comment.class));
    }

    @Test
    void removeComment(){
        commentService.removeComment(1L);

        verify(commentRepository, times(1)).deleteById(1L);
    }


}