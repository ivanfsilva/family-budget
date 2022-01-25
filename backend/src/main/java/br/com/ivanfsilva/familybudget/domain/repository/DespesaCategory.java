package br.com.ivanfsilva.familybudget.domain.repository;

import br.com.ivanfsilva.familybudget.domain.model.orcamento.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaCategory extends JpaRepository<Despesa, Long> {
}
