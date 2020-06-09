package com.gokhany.basictodo.controller;

import com.gokhany.basictodo.dto.Request.AuthRequest;
import com.gokhany.basictodo.dto.Response.AuthResponse;
import com.gokhany.basictodo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @NotNull
    private final AuthService authService;

    @PostMapping("register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody AuthRequest authRequest){
        return new ResponseEntity<>(authService.registerUser(authRequest), HttpStatus.CREATED);
    }

    @GetMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestParam(name="username") String username,
                                              @RequestParam String password){
        return new ResponseEntity<>(authService.loginUser(username, password), HttpStatus.OK);
    }


}
