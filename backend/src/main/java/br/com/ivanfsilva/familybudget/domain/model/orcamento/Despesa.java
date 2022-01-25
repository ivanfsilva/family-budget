package br.com.ivanfsilva.familybudget.domain.model.orcamento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "despesas")
//@DiscriminatorValue("despesa")
public class Despesa extends Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Campo CATEGORIA é requerido")
    @Enumerated(EnumType.STRING)
    protected Categoria categoria;

    public Despesa() {
    }

    public Despesa(Long id, String descricao, BigDecimal valor, LocalDate data, Categoria categoria, Lancamento lancamento) {
        super(id, descricao, valor, data, lancamento);
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
