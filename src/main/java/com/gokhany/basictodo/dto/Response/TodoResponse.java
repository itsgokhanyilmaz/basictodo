package com.gokhany.basictodo.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoResponse {

    private String title;

    private String description;

    private boolean done;

    private Date dueDate;

}
