package br.com.ivanfsilva.familybudget.domain.repository;

import br.com.ivanfsilva.familybudget.domain.model.orcamento.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    Optional<Despesa> findByDescricaoAndData(String descricao, LocalDate data);
}
