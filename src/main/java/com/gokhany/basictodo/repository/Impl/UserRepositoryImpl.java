package com.gokhany.basictodo.repository.Impl;

import com.gokhany.basictodo.dto.Request.UserDetailRequest;
import com.gokhany.basictodo.entity.User;
import com.gokhany.basictodo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public User save(User user) {
        return mongoTemplate.save(user);
    }

    @Override
    public Optional<User> findById(ObjectId id) {
        return Optional.ofNullable(mongoTemplate
                .findOne(Query.query(Criteria.where("_id").is(id)), User.class));
    }

    @Override
    public Optional<User> findByUserName(String username) {
        return Optional.ofNullable(mongoTemplate
                .findOne(Query.query(Criteria.where("username").is(username)), User.class));
    }

    @Override
    public void updateUserDetailInfo(String userId, UserDetailRequest userDetailRequest) {

    }
}
