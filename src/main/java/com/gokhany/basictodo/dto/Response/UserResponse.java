package com.gokhany.basictodo.dto.Response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String id;

    private String username;

    private String email;

    private String company;

    private String jobTitle;

}
