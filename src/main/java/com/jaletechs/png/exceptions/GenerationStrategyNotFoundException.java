package com.jaletechs.png.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jaletechs on 2019-06-01.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class GenerationStrategyNotFoundException extends RuntimeException {
    public GenerationStrategyNotFoundException(String message) {
        super(message);
    }
} 
