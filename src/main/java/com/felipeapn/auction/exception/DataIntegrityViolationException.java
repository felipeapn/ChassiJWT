package com.felipeapn.auction.exception;

import lombok.Getter;

@Getter
public class DataIntegrityViolationException extends RuntimeException{

    private static final long serialVersionUID = -1492620029738017714L;

    public DataIntegrityViolationException(String mensagem) {
        super(mensagem);
    }

    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
