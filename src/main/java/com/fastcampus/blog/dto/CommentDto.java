package com.fastcampus.blog.dto;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CommentDto {

    @NonNull
    private String content;

}
