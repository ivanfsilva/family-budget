package br.com.ivanfsilva.familybudget.domain.model.orcamento;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Lancamento lancamento;

    public Categoria() {
    }

    public Categoria(int id, String nome, Lancamento lancamento) {
        this.id = id;
        this.nome = nome;
        this.lancamento = lancamento;
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
