package br.com.ivanfsilva.familybudget.domain.model.orcamento;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "orcamento")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_lancamento",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Orcamento extends EntidadeBaseInteger implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Campo DESCRIÇÃO é requerido")
    @Length(min = 5, max = 50, message = "O campo descrição deve ter entre 5 e 50 caracteres")
    @Column(nullable=false, length=50)
    protected String descricao;

    @NotNull(message = "Campo VALOR é requerido")
    @DecimalMin(value = "0.0", inclusive = false, message = "O campo valor deve ser maior que zero")
    @Digits(integer=5, fraction=2)
    protected BigDecimal valor;
    protected LocalDate data;

    @NotNull(message = "Campo CATEGORIA é requerido")
    @OneToOne
    protected Categoria categoria;

    @Enumerated(EnumType.STRING)
    protected Lancamento lancamento;

    public Orcamento() {
    }

    public Orcamento(Long id, String descricao, BigDecimal valor, LocalDate data, Categoria categoria, Lancamento lancamento) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
        this.lancamento = lancamento;
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

}
