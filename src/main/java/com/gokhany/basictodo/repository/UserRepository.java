package com.gokhany.basictodo.repository;

import com.gokhany.basictodo.dto.Request.UserDetailRequest;
import com.gokhany.basictodo.entity.User;
import org.bson.types.ObjectId;

import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(ObjectId id);

    Optional<User> findByUserName(String username);

    void updateUserDetailInfo(String userId, UserDetailRequest userDetailRequest);



}
