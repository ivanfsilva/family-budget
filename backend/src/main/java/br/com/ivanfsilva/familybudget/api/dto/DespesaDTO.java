package br.com.ivanfsilva.familybudget.api.dto;

import br.com.ivanfsilva.familybudget.domain.model.orcamento.Categoria;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Despesa;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Lancamento;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DespesaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull(message = "Campo DESCRIÇÃO é requerido")
    protected String descricao;

    @NotNull(message = "Campo VALOR é requerido")
    protected BigDecimal valor;

    @NotNull(message = "Campo Data de Nascimento é obrigatório")
    protected LocalDate data;

    @Enumerated(EnumType.STRING)
    protected Lancamento lancamento;

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

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
