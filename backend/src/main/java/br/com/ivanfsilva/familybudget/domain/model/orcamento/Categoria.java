package br.com.ivanfsilva.familybudget.domain.model.orcamento;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity(name = "categorias")
public class Categoria extends EntidadeBaseInteger implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Campo NOME é requerido")
    @Length(min = 5, max = 50, message = "O campo nome deve ter entre 5 e 50 caracteres")
    private String nome;

    @NotEmpty(message = "Campo LANÇAMENTO é requerido")
    @Enumerated(EnumType.STRING)
    private Lancamento lancamento;

    public Categoria() {
    }

    public Categoria(String nome, Lancamento lancamento) {
        this.nome = nome;
        this.lancamento = lancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }
}
