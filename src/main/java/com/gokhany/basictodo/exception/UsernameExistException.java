package com.gokhany.basictodo.exception;

public class UsernameExistException extends BaseException {
    public UsernameExistException(){
        super(ExceptionCode.USERNAME_EXIST);
    }
}
