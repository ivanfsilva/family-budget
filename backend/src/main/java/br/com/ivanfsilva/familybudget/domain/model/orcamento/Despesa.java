package br.com.ivanfsilva.familybudget.domain.model.orcamento;

import javax.persistence.DiscriminatorValue;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@DiscriminatorValue("despesa")
public class Despesa extends Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;

    public Despesa(Long id, String descricao, BigDecimal valor, LocalDate data, Categoria categoria, Lancamento lancamento) {
        super(id, descricao, valor, data, categoria, lancamento);
    }
}
