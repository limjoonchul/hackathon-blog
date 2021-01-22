package com.fastcampus.blog.service;

import com.fastcampus.blog.dto.CommentDto;
import com.fastcampus.blog.model.Comment;
import com.fastcampus.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment getCommentById(Long id) {

        Optional<Comment> findComment = commentRepository.findById(id);

        return findComment.orElseGet(() -> findComment.orElse(new Comment()));
    }

    public void saveComment(@Valid CommentDto commentDto) {

        Comment comment = new Comment();

        comment.setContent(commentDto.getContent());
        comment.setPost(commentDto.getPost());
        comment.setMember(commentDto.getMember());

        commentRepository.save(comment);

    }

    public void removeComment(Long id) {
        commentRepository.deleteById(id);
    }

    public void updateComment(@Valid CommentDto commentDto) {
        Optional<Comment> findComment = commentRepository.findById(commentDto.getId());
        Comment comment = findComment.get();

        comment.setContent(commentDto.getContent());

        commentRepository.save(comment);
    }

}
