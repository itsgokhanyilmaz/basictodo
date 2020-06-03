package com.gokhany.basictodo.service.Impl;

import com.gokhany.basictodo.dto.Request.TodoRequest;
import com.gokhany.basictodo.dto.Response.TodoResponse;
import com.gokhany.basictodo.entity.Todo;
import com.gokhany.basictodo.exception.TodoNotFoundException;
import com.gokhany.basictodo.repository.TodoRepository;
import com.gokhany.basictodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    @NotNull
    private final ModelMapper modelMapper;

    @NotNull
    private final TodoRepository todoRepository;

    @Override
    public TodoResponse getTodo(String id) {
        Todo todo = todoRepository.getTodo(id).orElseThrow(TodoNotFoundException::new);
        return modelMapper.map(todo, TodoResponse.class);
    }

    @Override
    public TodoResponse saveTodo(TodoRequest todoRequest) {
        final Todo todo = modelMapper.map(todoRequest, Todo.class);
        Todo savedTodo = todoRepository.save(todo);

        return modelMapper.map(savedTodo, TodoResponse.class);
    }

    @Override
    public TodoResponse removeTodo(String todoId) {
        Todo deletedTodo = todoRepository.remove(new ObjectId(todoId));
        return modelMapper.map(deletedTodo, TodoResponse.class);
    }
}
