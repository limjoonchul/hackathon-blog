package com.fastcampus.blog.repository;

import com.fastcampus.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findCommentByMember_Nickname(String nickname);
}
