package com.gokhany.basictodo.controller;


import com.gokhany.basictodo.dto.Response.TodoResponse;
import com.gokhany.basictodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<TodoResponse> getTodo(
            @RequestParam String id,
            HttpServletRequest httpServletRequest){
        return new ResponseEntity<>(todoService.getTodo(id), HttpStatus.OK);
    }


}
