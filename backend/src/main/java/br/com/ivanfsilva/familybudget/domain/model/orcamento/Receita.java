package br.com.ivanfsilva.familybudget.domain.model.orcamento;

import javax.persistence.DiscriminatorValue;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@DiscriminatorValue("receita")
public class Receita extends Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;

    public Receita(Long id, String descricao, BigDecimal valor, LocalDate data, Categoria categoria) {
        super(id, descricao, valor, data, categoria, Lancamento.RECEITA);
    }
}
