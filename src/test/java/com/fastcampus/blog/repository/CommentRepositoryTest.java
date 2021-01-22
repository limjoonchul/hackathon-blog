package com.fastcampus.blog.repository;

import com.fastcampus.blog.model.Comment;
import com.fastcampus.blog.model.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;


    @Test
    void getCommentByMemberNickName(){
        // given

        // when
        Optional<Comment> findComment = commentRepository.findCommentByMember_Nickname("martin");
        Comment  comment1 = findComment.get();

        // then
        assertThat(comment1.getContent()).isEqualTo("제목입니다");
    }

}