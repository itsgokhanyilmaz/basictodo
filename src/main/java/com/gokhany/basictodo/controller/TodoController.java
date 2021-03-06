package com.gokhany.basictodo.controller;


import com.gokhany.basictodo.dto.Request.TodoRequest;
import com.gokhany.basictodo.dto.Response.TodoResponse;
import com.gokhany.basictodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("detail-todo/{id}")
    public ResponseEntity<TodoResponse> getTodo(@PathVariable String id){
        return new ResponseEntity<>(todoService.getTodo(id), HttpStatus.OK);
    }

    @PostMapping("add-todo")
    public ResponseEntity<TodoResponse> addTodo(@Valid TodoRequest todoRequest){
        return new ResponseEntity<>(todoService.saveTodo(todoRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("remove-todo/{id}")
    public ResponseEntity<TodoResponse> removeTodo(@PathVariable String id){
        return new ResponseEntity<>(todoService.removeTodo(id), HttpStatus.OK);
    }

    @PutMapping("update-todo-detail/{id}")
    public ResponseEntity<TodoResponse> updateTodoDetail(@PathVariable String id,
                                                         @Valid @RequestBody TodoRequest todoRequest){
        return new ResponseEntity<>(todoService.updateTodoDetail(id, todoRequest), HttpStatus.OK);
    }

}
