package com.gokhany.basictodo.repository.Impl;

import com.gokhany.basictodo.dto.Request.TodoRequest;
import com.gokhany.basictodo.entity.Todo;
import com.gokhany.basictodo.exception.TodoUpdateException;
import com.gokhany.basictodo.repository.TodoRepository;
import com.mongodb.client.result.UpdateResult;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    @Override
    public Optional<Todo> remove(ObjectId todoId) {
        Todo todo = mongoTemplate.findAndRemove(Query.query(Criteria.where("_id").is(todoId)), Todo.class);
        return Optional.ofNullable(todo);
    }

    @Override
    public void updateTodoDetail(String id, TodoRequest todoRequest) {
        UpdateResult updateResult = mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(id)),
                new Update()
                        .set("description", todoRequest.getDescription())
                        .set("done", todoRequest.getDone())
                        .set("title", todoRequest.getTitle())
                        .set("due_date", todoRequest.getDueDate()), Todo.class);

        if (!updateResult.wasAcknowledged()){
            throw new TodoUpdateException();
        }

    }
}
