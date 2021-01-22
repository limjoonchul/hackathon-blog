package com.fastcampus.blog.service;

import com.fastcampus.blog.dto.CommentDto;
import com.fastcampus.blog.model.Comment;
import com.fastcampus.blog.model.Post;
import com.fastcampus.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment getCommentById(Long id){

        Optional<Comment> findComment = commentRepository.findById(id);

        return findComment.orElseGet(() -> findComment.orElse(new Comment()));
    }

    public void removeComment(Long id){
        commentRepository.deleteById(id);
    }
    
}
