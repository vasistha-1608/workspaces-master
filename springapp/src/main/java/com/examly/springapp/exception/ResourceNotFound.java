package com.examly.springapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{
    static final long serialVersionUID =1L;
    public ResourceNotFound(String message)
    {
        super(message);
    }
    
}
