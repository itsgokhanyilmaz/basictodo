package com.gokhany.basictodo.service.Impl;

import com.gokhany.basictodo.dto.Request.AuthRequest;
import com.gokhany.basictodo.dto.Response.AuthResponse;
import com.gokhany.basictodo.entity.User;
import com.gokhany.basictodo.exception.UserOrPasswordWrongException;
import com.gokhany.basictodo.exception.UsernameExistException;
import com.gokhany.basictodo.repository.UserRepository;
import com.gokhany.basictodo.service.AuthService;
import com.gokhany.basictodo.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @NotNull
    private final UserRepository userRepository;

    @NotNull
    private final ModelMapper modelMapper;

    @NotNull
    private final JwtUtil jwtUtil;

    @NotNull
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AuthResponse registerUser(AuthRequest authRequest) {

        final User user = modelMapper.map(authRequest, User.class);

        Optional<User> byUserName = userRepository.findByUserName(authRequest.getUsername());

        if (byUserName.isPresent()){
            throw new UsernameExistException();
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);

        AuthResponse authResponse = modelMapper.map(savedUser, AuthResponse.class);
        authResponse.setToken(jwtUtil.createToken(savedUser.getId()));

        return authResponse;
    }

    @Override
    public AuthResponse loginUser(String username, String password) {
        final User user = userRepository.findByUserName(username)
                .orElseThrow(UserOrPasswordWrongException::new);

        if (bCryptPasswordEncoder.matches(password, user.getPassword())){
            AuthResponse authResponse = modelMapper.map(user, AuthResponse.class);
            authResponse.setToken(jwtUtil.createToken(user.getId()));
            return authResponse;
        }else{
            throw new UserOrPasswordWrongException();
        }
    }
}
