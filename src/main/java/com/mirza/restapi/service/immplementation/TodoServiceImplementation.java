package com.mirza.restapi.service.immplementation;

import com.mirza.restapi.entity.Todo;
import com.mirza.restapi.dto.request.TodoDtoRequest;
import com.mirza.restapi.dto.response.TodoDtoResponse;
import com.mirza.restapi.enums.StatusEnum;
import com.mirza.restapi.exception.TodoNotFoundException;
import com.mirza.restapi.repository.TodoRepository;
import com.mirza.restapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImplementation implements TodoService {
    private final TodoRepository todoRepository;

    private final ModelMapper modelMapper;
    @Override
    public List<TodoDtoResponse> getAllTodoList() {
        List<Todo> todoList = todoRepository.findAll();

        return todoList.stream()
                .map(todo -> modelMapper.map(todo, TodoDtoResponse.class))
                .toList();
    }

    @Override
    public void addTodo(TodoDtoRequest todoDtoRequest) {
        Todo todo = new Todo();
        todo.setStatus(StatusEnum.TO_DO);
        todo.setTodo(todoDtoRequest.getTodo());
        todoRepository.save(todo);
    }

    @Override
    public void updateTodo(Long id, TodoDtoRequest todoDtoRequest) {
        Todo todo = todoRepository.findById(id.intValue())
                .orElseThrow(() -> new TodoNotFoundException("Todo Not Found"));
        todo.setStatus(todoDtoRequest.getStatus());
        todo.setTodo(todo.getTodo());
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id.intValue())
                .orElseThrow(() -> new TodoNotFoundException("Todo Not Found"));
        todoRepository.delete(todo);
    }

    @Override
    public List<TodoDtoResponse> getByFilter(StatusEnum statusEnum) {
        List<Todo> todoList = todoRepository.findAllByStatus(statusEnum);
        return todoList.stream()
                .map(todo -> modelMapper.map(todo, TodoDtoResponse.class))
                .toList();
    }
}
