package br.com.ivanfsilva.familybudget.api.dto;

import br.com.ivanfsilva.familybudget.domain.model.orcamento.Categoria;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Lancamento;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Receita;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ReceitaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    private String descricao;

    @NotNull
    private Lancamento lancamento;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private LocalDate data;

    public ReceitaDTO() {
    }

    public ReceitaDTO(Receita receita) {
        this.id = receita.getId();
        this.descricao = receita.getDescricao();
        this.lancamento = receita.getLancamento();
        this.valor = receita.getValor();
        this.data = receita.getData();
    }

    public static List<ReceitaDTO> converterLista(List<Receita> receitas) {
        return receitas.stream().map(ReceitaDTO::new).collect(Collectors.toList());
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

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
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
}
