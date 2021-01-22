package com.fastcampus.blog.dto;


import com.fastcampus.blog.model.Blog;
import com.fastcampus.blog.model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    private Blog blog;

    private Member Member;

}
