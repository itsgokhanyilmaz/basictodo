package com.gokhany.basictodo.repository.Impl;

import com.gokhany.basictodo.entity.Todo;
import com.gokhany.basictodo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class TodoRepositoryImpl implements TodoRepository {
    @NotNull
    private final MongoTemplate mongoTemplate;

    @Override
    public Optional<Todo> getTodo(String todoId) {
        Todo todo = mongoTemplate.findOne(Query.query(Criteria.where("_id").is(todoId)), Todo.class);
        return Optional.ofNullable(todo);
    }

    @Override
    public Todo save(Todo todo) {
        return mongoTemplate.save(todo);
    }
}
