package br.com.ivanfsilva.familybudget.domain.service;

import br.com.ivanfsilva.familybudget.api.dto.DespesaDTO;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Despesa;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Receita;
import br.com.ivanfsilva.familybudget.domain.repository.DespesaRepository;
import br.com.ivanfsilva.familybudget.domain.service.exceptions.DatabaseException;
import br.com.ivanfsilva.familybudget.domain.service.exceptions.DespesaExistenteException;
import br.com.ivanfsilva.familybudget.domain.service.exceptions.ReceitaExistenteException;
import br.com.ivanfsilva.familybudget.domain.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
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
        verificaDespesaExistente(dto.getDescricao(), dto.getData());

        Despesa entity = new Despesa();
        copyDtoToEntity(dto, entity);
        entity = despesaRepository.save(entity);
        return new DespesaDTO(entity);
    }

    @Transactional
    public DespesaDTO update(Long id, DespesaDTO dto) {
        verificaDespesaExistente(dto.getDescricao(), dto.getData());

        try {
            Despesa entity = despesaRepository.getById(id);
            copyDtoToEntity(dto, entity);
            entity = despesaRepository.save(entity);
            return new DespesaDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("id não encontrado " + id);
        }
    }

    @Transactional
    public void delete(Long id) {
        try {
            despesaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("id não encontrado " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integridade violada");
        }
    }

    private void copyDtoToEntity(DespesaDTO dto, Despesa entity) {
        entity.setDescricao(dto.getDescricao());
        entity.setData(dto.getData());
        entity.setLancamento(dto.getLancamento());
        entity.setValor(dto.getValor());
        entity.setCategoria(dto.getCategoria());
    }

    private void verificaDespesaExistente(String descricao, LocalDate data) {
        Optional<Despesa> despesaEncontrada = despesaRepository.findByDescricaoAndData(descricao, data);
        if(despesaEncontrada.isPresent()) {
            throw new DespesaExistenteException("Já existe uma DESPESA cadastrada com a mesma descrição no mês informado");
        }
    }
}
