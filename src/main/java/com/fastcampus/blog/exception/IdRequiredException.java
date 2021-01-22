package com.fastcampus.blog.exception;

public class IdRequiredException extends RuntimeException{
    public IdRequiredException(String message) {
        super(message);
    }
}
