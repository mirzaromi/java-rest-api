package com.mirza.restapi.service;

import com.mirza.restapi.dto.request.TodoDtoRequest;
import com.mirza.restapi.dto.response.TodoDtoResponse;
import com.mirza.restapi.enums.StatusEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {
    List<TodoDtoResponse> getAllTodoList();

    void addTodo(TodoDtoRequest todoDtoRequest);

    void updateTodo(Long id, TodoDtoRequest todoDtoRequest);

    void deleteTodo(Long id);

    List<TodoDtoResponse> getByFilter(StatusEnum statusEnum);

}
