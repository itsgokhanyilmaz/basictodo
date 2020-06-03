package com.gokhany.basictodo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo extends BaseEntity {

    private String title;

    private String description;

    private Boolean done;

    @Field("due_date")
    private Date dueDate;

}
