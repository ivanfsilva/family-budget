package br.com.ivanfsilva.familybudget.api.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
    }

    public ValidationError(Long timeStamp, Integer status, String error) {
        super(timeStamp, status, error);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String message ) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
