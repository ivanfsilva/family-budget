package br.com.ivanfsilva.familybudget.domain.exceptionhandler;

public class ObjectNotFoundExceptions extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundExceptions(String message) {
        super(message);
    }

    public ObjectNotFoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
