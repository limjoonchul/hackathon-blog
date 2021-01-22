package com.fastcampus.blog.dto;


import com.fastcampus.blog.model.Member;
import com.fastcampus.blog.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long id;

    @NotEmpty
    private String content;

    private Post post;

    private Member member;


}
