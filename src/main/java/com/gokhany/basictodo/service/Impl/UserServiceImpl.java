package com.gokhany.basictodo.service.Impl;

import com.gokhany.basictodo.dto.Request.UserDetailRequest;
import com.gokhany.basictodo.dto.Response.UserResponse;
import com.gokhany.basictodo.entity.User;
import com.gokhany.basictodo.exception.UserNotFoundException;
import com.gokhany.basictodo.repository.UserRepository;
import com.gokhany.basictodo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @NotNull
    private final ModelMapper modelMapper;

    @NotNull
    private final UserRepository userRepository;

    @Override
    public UserResponse getUser(String userId) {
        User user = userRepository.findById(new ObjectId(userId)).orElseThrow(UserNotFoundException::new);
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse setUserDetailInformation(String userId, UserDetailRequest userDetailRequest) {
        userRepository.updateUserDetailInfo(userId, userDetailRequest);
        User user = userRepository.findById(new ObjectId(userId))
                .orElseThrow(UserNotFoundException::new);
        return modelMapper.map(user, UserResponse.class);
    }
}
