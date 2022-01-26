package br.com.ivanfsilva.familybudget.domain.service.exceptions;

public class InformacaoDesconhecidaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InformacaoDesconhecidaException(String msg) {
        super(msg);
    }
}
