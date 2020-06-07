package com.gokhany.basictodo.exception;

public class UserOrPasswordWrongException extends BaseException{
    public UserOrPasswordWrongException() {
        super(ExceptionCode.USER_OR_PASSWORD_WRONG);
    }
}
