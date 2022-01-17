package br.com.ivanfsilva.familybudget.domain.model.orcamento;

public enum Lancamento {

    RECEITA("Receita"),
    DESPESA_FIXA("Despesa Fixa"),
    DESPESA_EVENTUAL("Despesa Eventual");

    private String descricao;

    Lancamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
