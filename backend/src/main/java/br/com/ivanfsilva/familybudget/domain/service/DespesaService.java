package br.com.ivanfsilva.familybudget.domain.service;

import br.com.ivanfsilva.familybudget.api.dto.DespesaDTO;
import br.com.ivanfsilva.familybudget.domain.exceptionhandler.ObjectNotFoundExceptions;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Despesa;
import br.com.ivanfsilva.familybudget.domain.repository.DespesaCategory;
import br.com.ivanfsilva.familybudget.domain.service.exceptions.ResourceNotFoundException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DespesaService {

    @Autowired
    private DespesaCategory despesaCategory;

    @Transactional(readOnly = true)
    public DespesaDTO findById(Long id) {
        Optional<Despesa> obj = despesaCategory.findById(id);
        Despesa entity = obj.orElseThrow( () -> new ResourceNotFoundException("Entidade não encontrada"));
        return new DespesaDTO(entity);
    }

    public List<DespesaDTO> findAll() {
        List<Despesa> list = despesaCategory.findAll();
        List<DespesaDTO> listDTO = list.stream().map( d -> new DespesaDTO(d)).collect(Collectors.toList());

        return listDTO;
    }
}
