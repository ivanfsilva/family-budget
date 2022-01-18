package br.com.ivanfsilva.familybudget.domain.model.orcamento;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Campo DESCRIÇÃO é requerido")
    @Length(min = 5, max = 50, message = "O campo descrição deve ter entre 5 e 50 caracteres")
    @Column(nullable=false, length=50)
    protected String descricao;

    @NotEmpty(message = "Campo VALOR é requerido")
    @DecimalMin(value = "0.0", inclusive = false, message = "O campo valor deve ser maior que zero")
    @Digits(integer=5, fraction=2)
    protected BigDecimal valor;
    protected LocalDate data;

    @NotEmpty(message = "Campo CATEGORIA é requerido")
    @Length(min = 5, max = 50, message = "O campo categoria deve ter entre 5 e 50 caracteres")
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
