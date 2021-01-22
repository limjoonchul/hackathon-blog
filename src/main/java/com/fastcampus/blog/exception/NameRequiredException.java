package com.fastcampus.blog.exception;

public class NameRequiredException extends RuntimeException{
    public NameRequiredException(String message) {
        super(message);
    }
}
