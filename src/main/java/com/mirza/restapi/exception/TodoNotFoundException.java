package com.mirza.restapi.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(String message) {
        super(message);
    }
}
