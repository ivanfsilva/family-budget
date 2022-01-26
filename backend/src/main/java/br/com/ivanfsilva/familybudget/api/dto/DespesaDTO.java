package br.com.ivanfsilva.familybudget.api.dto;

import br.com.ivanfsilva.familybudget.domain.model.orcamento.Categoria;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Despesa;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Lancamento;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Receita;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DespesaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    protected String descricao;

    @NotNull
    protected BigDecimal valor;

    @NotNull
    protected LocalDate data;

    @Enumerated(EnumType.STRING)
    protected Lancamento lancamento;

    @NotNull(message = "Campo CATEGORIA é requerido")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public DespesaDTO() {
    }

    public DespesaDTO(Despesa despesa) {
        this.id = despesa.getId();
        this.descricao = despesa.getDescricao();
        this.valor = despesa.getValor();
        this.data = despesa.getData();
        this.lancamento = despesa.getLancamento();
        this.categoria = despesa.getCategoria();
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

    public Lancamento getLancamento() {
        return lancamento;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
