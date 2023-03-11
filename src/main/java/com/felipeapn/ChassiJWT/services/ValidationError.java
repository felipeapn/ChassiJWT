package com.felipeapn.ChassiJWT.services;

import com.felipeapn.ChassiJWT.exception.handler.FieldMessage;
import com.felipeapn.ChassiJWT.exception.handler.StandardError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
public class ValidationError extends StandardError {

    @Serial
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Long timestamp, String error, String message, String path) {
        super(timestamp, error, message, path);

    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
