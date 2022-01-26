package br.com.ivanfsilva.familybudget.domain.model.orcamento;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntidadeBaseInteger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public EntidadeBaseInteger() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntidadeBaseInteger that = (EntidadeBaseInteger) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
