package com.fastcampus.blog.controller;

import com.fastcampus.blog.dto.CommentDto;
import com.fastcampus.blog.model.Comment;
import com.fastcampus.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/api/comment/{id}")
    public Comment getComment(@PathVariable Long id){
        return commentService.getCommentById(id);

    }

    @PostMapping("/api/comment")
    public void saveComment(@Valid CommentDto commentDto){
        commentService.saveComment(commentDto);
    }

    @PutMapping("/api/comment")
    public void updateComment(@Valid CommentDto commentDto){
        commentService.updateComment(commentDto);
    }

    @DeleteMapping("/api/comment")
    public void deletedComment(Long id){
        commentService.removeComment(id);
    }


}
