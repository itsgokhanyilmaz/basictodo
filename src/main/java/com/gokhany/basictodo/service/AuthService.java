package com.gokhany.basictodo.service;

import com.gokhany.basictodo.dto.Request.AuthRequest;
import com.gokhany.basictodo.dto.Response.AuthResponse;

public interface AuthService {

    AuthResponse registerUser(AuthRequest authRequest);

    AuthResponse loginUser(String username, String password);
}
