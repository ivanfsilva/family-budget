package br.com.ivanfsilva.familybudget.domain.service;

import br.com.ivanfsilva.familybudget.api.dto.DespesaDTO;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Despesa;
import br.com.ivanfsilva.familybudget.domain.repository.DespesaRepository;
import br.com.ivanfsilva.familybudget.domain.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    @Transactional(readOnly = true)
    public DespesaDTO findById(Long id) {
        Optional<Despesa> obj = despesaRepository.findById(id);
        Despesa entity = obj.orElseThrow( () -> new ResourceNotFoundException("Entidade não encontrada"));
        return new DespesaDTO(entity);
    }

    public List<DespesaDTO> findAll() {
        List<Despesa> list = despesaRepository.findAll();
        List<DespesaDTO> listDTO = list.stream().map( d -> new DespesaDTO(d)).collect(Collectors.toList());

        return listDTO;
    }

    @Transactional
    public DespesaDTO insert(DespesaDTO dto) {
        Despesa entity = new Despesa();
        copyDtoToEntity(dto, entity);
        entity = despesaRepository.save(entity);
        return new DespesaDTO(entity);
    }

    private void copyDtoToEntity(DespesaDTO dto, Despesa entity) {
        entity.setDescricao(dto.getDescricao());
        entity.setData(dto.getData());
        entity.setLancamento(dto.getLancamento());
        entity.setValor(dto.getValor());
        entity.setCategoria(dto.getCategoria());
    }
}
