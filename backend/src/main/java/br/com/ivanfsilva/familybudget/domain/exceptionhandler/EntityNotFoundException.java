package br.com.ivanfsilva.familybudget.domain.exceptionhandler;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }
}
