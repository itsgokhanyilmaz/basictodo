package com.gokhany.basictodo.dto.Response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {

    private String id;

    private String username;

    private String password;

    private String token;

}
