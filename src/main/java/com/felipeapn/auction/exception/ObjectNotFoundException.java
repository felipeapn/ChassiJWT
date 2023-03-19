package com.felipeapn.auction.exception;

import lombok.Getter;

@Getter
public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -1492620029738017714L;

    public ObjectNotFoundException(String mensagem) {
        super(mensagem);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
