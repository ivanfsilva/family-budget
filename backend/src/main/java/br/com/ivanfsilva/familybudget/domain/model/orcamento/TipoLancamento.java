package br.com.ivanfsilva.familybudget.domain.model.orcamento;

public enum TipoLancamento {

    Receita("RECEITA"),
    Despesa("DESPESA");

    private String descricao;

    TipoLancamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
