package com.loja_sanderson.loja.exception;

public class HttpException extends Exception {
    final Integer code;
    public HttpException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
