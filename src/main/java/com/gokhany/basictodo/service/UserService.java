package com.gokhany.basictodo.service;

import com.gokhany.basictodo.dto.Request.UserDetailRequest;
import com.gokhany.basictodo.dto.Response.UserResponse;

public interface UserService {

    UserResponse getUser(String userId);

    UserResponse setUserDetailInformation(String userId, UserDetailRequest userDetailRequest);



}
