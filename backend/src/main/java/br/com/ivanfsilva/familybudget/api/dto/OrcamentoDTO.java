package br.com.ivanfsilva.familybudget.api.dto;

import br.com.ivanfsilva.familybudget.domain.model.orcamento.Lancamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class OrcamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    protected String descricao;

    @NotNull
    protected BigDecimal valor;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate data;

    @Enumerated(EnumType.STRING)
    protected Lancamento lancamento;
}
