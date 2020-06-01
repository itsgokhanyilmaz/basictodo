package com.gokhany.basictodo.exception;

public class TodoNotFoundException extends BaseException {

    public TodoNotFoundException(){
        super(ExceptionCode.TODO_NOT_FOUND);
    }
}
