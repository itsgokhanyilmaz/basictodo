package com.gokhany.basictodo.repository;

import com.gokhany.basictodo.entity.Todo;

import java.util.Optional;

public interface TodoRepository {

    Optional<Todo> getTodo(String todoId);

    //Optional<Todo> getTodoById(ObjectId todoId);

    Todo save(Todo todo);
}
