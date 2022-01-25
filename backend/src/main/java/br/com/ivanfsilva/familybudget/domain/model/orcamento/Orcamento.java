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
//@Table(name = "orcamento")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "tipo_lancamento",
//        discriminatorType = DiscriminatorType.STRING)
public abstract class Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Campo DESCRIÇÃO é requerido")
    @Length(min = 5, max = 50, message = "O campo descrição deve ter entre 5 e 50 caracteres")
    @Column(nullable=false, length=50)
    protected String descricao;

    @NotNull(message = "Campo VALOR é requerido")
    @DecimalMin(value = "0.0", inclusive = false, message = "O campo valor deve ser maior que zero")
    @Digits(integer=5, fraction=2)
    protected BigDecimal valor;
    protected LocalDate data;

    @Enumerated(EnumType.STRING)
    protected Lancamento lancamento;

    public Orcamento() {
    }

    public Orcamento(Long id, String descricao, BigDecimal valor, LocalDate data, Lancamento lancamento) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.lancamento = lancamento;
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
}
