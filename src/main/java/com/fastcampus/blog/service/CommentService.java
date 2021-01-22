package com.fastcampus.blog.service;

import com.fastcampus.blog.dto.CommentDto;
import com.fastcampus.blog.exception.NameRequiredException;
import com.fastcampus.blog.model.Comment;
import com.fastcampus.blog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.Valid;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment getCommentById(Long id) {

        Optional<Comment> findComment = commentRepository.findById(id);

        return findComment.orElseGet(() -> findComment.orElse(Comment.emptyObject()));
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

        Comment comment = findComment.orElse(Comment.emptyObject());
        comment.setContent(commentDto.getContent());
  
        commentRepository.save(comment);
    }

    public Comment getCommentByMemberNickName(String name) {

        if (!StringUtils.hasText(name)) {
            throw new NameRequiredException("NickName을 확인 하세요!");
        }

        Optional<Comment> findCommentByNickName = commentRepository.findCommentByMember_Nickname(name);


        return findCommentByNickName.orElse(Comment.emptyObject());

    }

}
