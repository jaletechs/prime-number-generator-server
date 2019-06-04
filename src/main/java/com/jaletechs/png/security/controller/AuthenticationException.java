package com.jaletechs.png.security.controller;
/**
 * Created by jaletechs on 2019-06-01.
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
