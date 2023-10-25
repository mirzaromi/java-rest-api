package com.mirza.restapi.controller;

import com.mirza.restapi.dto.request.TodoDtoRequest;
import com.mirza.restapi.dto.response.BaseResponse;
import com.mirza.restapi.dto.response.TodoDtoResponse;
import com.mirza.restapi.enums.StatusEnum;
import com.mirza.restapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/get")
    public ResponseEntity<BaseResponse<List<TodoDtoResponse>>> getAllTodo(){
        List<TodoDtoResponse> todoDtoResponseList = todoService.getAllTodoList();
        BaseResponse<List<TodoDtoResponse>> baseResponse = new BaseResponse<>(
                HttpStatus.OK.value(),
                "Success get all data",
                todoDtoResponseList
        );

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/get/filter")
    public ResponseEntity<BaseResponse<List<TodoDtoResponse>>> getAllTodo(@RequestParam StatusEnum statusEnum){
        List<TodoDtoResponse> todoDtoResponseList = todoService.getByFilter(statusEnum);
        BaseResponse<List<TodoDtoResponse>> baseResponse = new BaseResponse<>(
                HttpStatus.OK.value(),
                "Success get all data",
                todoDtoResponseList
        );

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public String addTodo(@RequestBody TodoDtoRequest todoDtoRequest){
        todoService.addTodo(todoDtoRequest);
        return "Success";
    }

    @PutMapping("/update/{id}")
    public String addTodo(@PathVariable Long id, @RequestBody TodoDtoRequest todoDtoRequest){
        todoService.updateTodo(id, todoDtoRequest);
        return "Success";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "success";
    }
}
