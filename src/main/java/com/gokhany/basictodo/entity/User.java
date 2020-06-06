package com.gokhany.basictodo.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseEntity {

    private String username;

    private String password;

    private String email;

    private String company;

    @Field("job_title")
    private String jobTitle;


}
