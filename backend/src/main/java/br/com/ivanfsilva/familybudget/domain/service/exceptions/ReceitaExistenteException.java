package br.com.ivanfsilva.familybudget.domain.service.exceptions;

public class ReceitaExistenteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ReceitaExistenteException(String msg) {
        super(msg);
    }
}
