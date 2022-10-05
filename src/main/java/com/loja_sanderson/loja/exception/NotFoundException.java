package com.loja_sanderson.loja.exception;

public class NotFoundException extends HttpException {
    public NotFoundException(String message){
        super(404, message);
    }
}
