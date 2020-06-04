package com.gokhany.basictodo.service;

import com.gokhany.basictodo.dto.Request.TodoRequest;
import com.gokhany.basictodo.dto.Response.TodoResponse;

public interface TodoService {

    TodoResponse getTodo(String id);

    TodoResponse saveTodo(TodoRequest todoRequest);

    TodoResponse removeTodo(String todoId);

}
