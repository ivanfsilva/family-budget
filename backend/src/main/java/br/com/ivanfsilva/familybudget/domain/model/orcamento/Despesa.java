package br.com.ivanfsilva.familybudget.domain.model.orcamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Despesa extends Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;

    public Despesa(Long id, String descricao, BigDecimal valor, LocalDate data) {
        super(id, descricao, valor, data, TipoLancamento.Despesa);
    }

}
