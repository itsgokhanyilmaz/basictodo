package com.gokhany.basictodo.exception;

public class UserNotFoundException extends BaseException{

    public UserNotFoundException() {
        super(ExceptionCode.USER_NOT_FOUND);
    }
}
