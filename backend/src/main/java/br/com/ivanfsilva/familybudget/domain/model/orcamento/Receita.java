package br.com.ivanfsilva.familybudget.domain.model.orcamento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "receitas")
//@DiscriminatorValue("receita")
public class Receita extends Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;

    public Receita() {
    }

    public Receita(Long id, String descricao, BigDecimal valor, LocalDate data) {
        super(id, descricao, valor, data, Lancamento.RECEITA);
    }

    public Receita(String descricao, BigDecimal valor, LocalDate data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }
}
