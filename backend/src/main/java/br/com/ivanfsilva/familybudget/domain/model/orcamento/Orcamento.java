package br.com.ivanfsilva.familybudget.domain.model.orcamento;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_lancamento")
public abstract class Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String descricao;
    protected BigDecimal valor;
    protected LocalDate data;

    @OneToOne
    protected Categoria categoria;

    @Enumerated(EnumType.STRING)
    protected Lancamento lancamento;

    public Orcamento() {
    }

    public Orcamento(Long id, String descricao, BigDecimal valor, LocalDate data, Categoria categoria, Lancamento lancamento) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
        this.lancamento = lancamento;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orcamento orcamento = (Orcamento) o;

        return id.equals(orcamento.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
