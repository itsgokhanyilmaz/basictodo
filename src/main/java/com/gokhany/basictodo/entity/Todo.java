package com.gokhany.basictodo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    private String title;
    private String description;
    private boolean done;
    private Date dueDate;

}
