package com.gokhany.basictodo.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequest {

    @NotNull
    private String title;

    @NotNull
    private String description;

    private Boolean done;

    @NotNull(message = "Due date cannot be null")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dueDate;

}
