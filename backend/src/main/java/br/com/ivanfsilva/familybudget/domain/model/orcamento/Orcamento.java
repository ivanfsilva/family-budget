package br.com.ivanfsilva.familybudget.domain.model.orcamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Long id;
    protected String descricao;
    protected BigDecimal valor;
    protected LocalDate data;

    protected TipoLancamento tipoLancamento;

    public Orcamento(Long id, String descricao, BigDecimal valor, LocalDate data, TipoLancamento tipoLancamento) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipoLancamento = tipoLancamento;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public TipoLancamento getTipoLancamento() {
        return tipoLancamento;
    }
}
