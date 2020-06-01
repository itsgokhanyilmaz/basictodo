package com.gokhany.basictodo.service.Impl;

import com.gokhany.basictodo.dto.Request.TodoRequest;
import com.gokhany.basictodo.dto.Response.TodoResponse;
import com.gokhany.basictodo.entity.Todo;
import com.gokhany.basictodo.exception.TodoNotFoundException;
import com.gokhany.basictodo.repository.TodoRepository;
import com.gokhany.basictodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    @NotNull
    private final ModelMapper modelMapper;

    @NotNull
    private final TodoRepository todoRepository;

    @Override
    public TodoResponse getTodo(String id) {
        Optional<Todo> optionalTodo = todoRepository.getTodo(id);
        Todo todo = optionalTodo.orElseThrow(TodoNotFoundException::new);
        TodoResponse todoResponse = modelMapper.map(todo, TodoResponse.class);
        return todoResponse;
    }

    // Todo
    @Override
    public TodoResponse saveTodo(String id, TodoRequest todoRequest) {
        return null;
    }
}
