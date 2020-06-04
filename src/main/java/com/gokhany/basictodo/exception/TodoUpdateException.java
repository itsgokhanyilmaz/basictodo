package com.gokhany.basictodo.exception;

public class TodoUpdateException extends BaseException {

    public TodoUpdateException() {
        super(ExceptionCode.TODO_UPDATE_FAILED);
    }
}
