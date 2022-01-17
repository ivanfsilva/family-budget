package br.com.ivanfsilva.familybudget.domain.repository;

import br.com.ivanfsilva.familybudget.domain.model.orcamento.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}