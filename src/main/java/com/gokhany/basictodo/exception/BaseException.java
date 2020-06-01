package com.gokhany.basictodo.exception;

public class BaseException extends RuntimeException{

    BaseException(String code) {
        super(code);
    }
}
