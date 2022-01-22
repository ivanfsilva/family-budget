package br.com.ivanfsilva.familybudget.domain.service;

import br.com.ivanfsilva.familybudget.api.dto.ReceitaDTO;
import br.com.ivanfsilva.familybudget.domain.exceptionhandler.EntityNotFoundException;
import br.com.ivanfsilva.familybudget.domain.exceptionhandler.ReceitaExistenteException;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Categoria;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Receita;
import br.com.ivanfsilva.familybudget.domain.repository.CategoriaRepository;
import br.com.ivanfsilva.familybudget.domain.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceitaService {

    @Autowired
    ReceitaRepository receitaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<ReceitaDTO> findAll() {
        List<Receita> list = receitaRepository.findAll();
        List<ReceitaDTO> listDTO = list.stream().map(r -> new ReceitaDTO( r, r.getCategoria() )).collect( Collectors.toList() );

        return listDTO;
    }

    public ResponseEntity<ReceitaDTO> create(ReceitaDTO receitaDTO, UriComponentsBuilder uriBuilder) throws ReceitaExistenteException {

        Categoria cat = verificaSeCategoriaExiste(receitaDTO);
        Receita receita = new Receita(null, receitaDTO.getDescricao(), receitaDTO.getValor(), receitaDTO.getData(), cat);
        verificaSeReceitaExisteNoMes(receita);

        receitaRepository.save(receita);
        URI uri  = uriBuilder.path("/receitas/{id}").buildAndExpand(receita.getId()).toUri();
        return ResponseEntity.created(uri).body(new ReceitaDTO(receita));
    }

    public ResponseEntity<ReceitaDTO> findById(Long id) {
        Optional<Receita> receitaOptional = receitaRepository.findById(id);
        Optional<Categoria> categoria = categoriaRepository.getById(receitaOptional.get().getCategoria().getId());
        return receitaOptional.map(receita -> ResponseEntity.ok(new ReceitaDTO(receita, categoria.get()))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional(readOnly = true)
    public Categoria verificaSeCategoriaExiste(ReceitaDTO receitaDTO) {
        Optional<Categoria> categoria = categoriaRepository.getById(receitaDTO.getCategoria().getId());

        return categoria.orElseThrow( () -> new EntityNotFoundException("Categoria inexistente"));
    }

    private void verificaSeReceitaExisteNoMes(Receita receita) throws ReceitaExistenteException {
        Optional<Receita> receitaEncontrada = receitaRepository.findByDescricaoAndData(receita.getDescricao(), receita.getData());
        if(receitaEncontrada.isPresent()) {
            throw new ReceitaExistenteException("Já existe uma receita cadastrada com a mesma descrição no mês informado");
        }
    }
}
