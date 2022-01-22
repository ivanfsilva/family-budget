package br.com.ivanfsilva.familybudget.domain.model.orcamento;

import br.com.ivanfsilva.familybudget.api.dto.CategoriaDTO;
import br.com.ivanfsilva.familybudget.api.dto.ReceitaDTO;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("receita")
public class Receita extends Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;

    public Receita() {
    }

    public Receita(Long id, String descricao, BigDecimal valor, LocalDate data, Categoria categoria) {
        super(id, descricao, valor, data, categoria, categoria.getLancamento());
    }

    public Receita(String descricao, BigDecimal valor, LocalDate data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

}
