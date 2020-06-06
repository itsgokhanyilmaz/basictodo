package com.gokhany.basictodo.controller;

import com.gokhany.basictodo.dto.Response.UserResponse;
import com.gokhany.basictodo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> userInfo(){

        // Todo jwt ile user id al
        String userId = "";
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }
}
