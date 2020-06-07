package com.gokhany.basictodo.controller;

import com.gokhany.basictodo.dto.Response.UserResponse;
import com.gokhany.basictodo.service.UserService;
import com.gokhany.basictodo.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> userInfo(HttpServletRequest httpServletRequest){

        String userId = JwtUtil.getObjectIdFromRequest(httpServletRequest);
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }
}
