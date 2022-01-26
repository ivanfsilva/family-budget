package br.com.ivanfsilva.familybudget.domain.service.exceptions;

public class DespesaExistenteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DespesaExistenteException(String msg) {
        super(msg);
    }
}
