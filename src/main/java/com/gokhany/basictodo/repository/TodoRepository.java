package com.gokhany.basictodo.repository;

import com.gokhany.basictodo.entity.Todo;
import org.bson.types.ObjectId;

import java.util.Optional;

public interface TodoRepository {

    Optional<Todo> getTodo(String todoId);

    Todo save(Todo todo);

    Todo remove(ObjectId todoId);
}
