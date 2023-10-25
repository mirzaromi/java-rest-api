package com.mirza.restapi.exception.handler;

import com.mirza.restapi.dto.response.BaseResponse;
import com.mirza.restapi.exception.TodoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TodoExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TodoNotFoundException.class)
    protected ResponseEntity<BaseResponse<Object>> handleEntityNotFound(TodoNotFoundException e){
        BaseResponse baseResponse = new BaseResponse(
                HttpStatus.BAD_REQUEST.value(),
                null,
                e.getMessage()
        );

        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }
}
