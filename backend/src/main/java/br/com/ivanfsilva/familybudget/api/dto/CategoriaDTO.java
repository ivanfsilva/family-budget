package br.com.ivanfsilva.familybudget.api.dto;

import br.com.ivanfsilva.familybudget.domain.model.orcamento.Categoria;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Lancamento;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;

    @NotEmpty(message = "Campo NOME é requerido")
    @Length(min = 5, max = 50, message = "O campo nome deve ter entre 5 e 50 caracteres")
    private String nome;

    @NotEmpty(message = "Campo LANÇAMENTO é requerido")
    @Length(min = 5, max = 50, message = "O campo lançamento deve ter entre 5 e 50 caracteres")
    @Enumerated(EnumType.STRING)
    private Lancamento lancamento;

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.lancamento = obj.getLancamento();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Lancamento getLancamento() {
        return lancamento;
    }
}
