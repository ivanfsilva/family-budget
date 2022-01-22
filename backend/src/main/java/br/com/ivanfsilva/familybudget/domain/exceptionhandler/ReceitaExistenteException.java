package br.com.ivanfsilva.familybudget.domain.exceptionhandler;

public class ReceitaExistenteException extends RuntimeException {

    public ReceitaExistenteException(String message) {
        super(message);
    }

    public ReceitaExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
