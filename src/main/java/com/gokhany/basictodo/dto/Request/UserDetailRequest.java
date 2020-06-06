package com.gokhany.basictodo.dto.Request;

import lombok.*;

import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailRequest  {

    @Email
    private String email;

    private String company;

    private String jobTitle;
}
