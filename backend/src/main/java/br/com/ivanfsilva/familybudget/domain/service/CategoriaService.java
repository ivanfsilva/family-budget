package br.com.ivanfsilva.familybudget.domain.service;

import br.com.ivanfsilva.familybudget.api.dto.CategoriaDTO;
import br.com.ivanfsilva.familybudget.domain.exceptionhandler.ObjectNotFoundExceptions;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Categoria;
import br.com.ivanfsilva.familybudget.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoria;

    public Categoria findById( Integer id ) {
        Optional<Categoria> obj = categoria.findById(id);

        return obj.orElseThrow( () -> new ObjectNotFoundExceptions(
                "Categoria não encontrada! id: " + id ));
    }

    public List<Categoria> findAll() {
        return categoria.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);

        return categoria.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDTO) {
        Categoria obj = findById(id);
        obj.setNome(objDTO.getNome());
        obj.setLancamento(objDTO.getLancamento());

        return categoria.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            categoria.deleteById(id);
        } catch ( DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Categoria não pode ser deletada! Possui lançamentos associados");
        }
    }
}
