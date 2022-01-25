package br.com.ivanfsilva.familybudget.domain.repository;

import br.com.ivanfsilva.familybudget.domain.model.orcamento.Orcamento;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    Optional<Receita> findByDescricaoAndData(String descricao, LocalDate data);

    Optional<Receita> findById(Receita receita);
}
