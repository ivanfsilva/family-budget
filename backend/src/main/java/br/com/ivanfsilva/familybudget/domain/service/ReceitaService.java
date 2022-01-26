package br.com.ivanfsilva.familybudget.domain.service;

import br.com.ivanfsilva.familybudget.api.dto.ReceitaDTO;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Receita;
import br.com.ivanfsilva.familybudget.domain.repository.ReceitaRepository;
import br.com.ivanfsilva.familybudget.domain.service.exceptions.ReceitaExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReceitaService {

    @Autowired
    ReceitaRepository receitaRepository;

    public List<ReceitaDTO> findAll() {
        List<Receita> list = receitaRepository.findAll();
        List<ReceitaDTO> listDTO = list.stream().map(r -> new ReceitaDTO( r )).collect( Collectors.toList() );

        return listDTO;
    }

    public ResponseEntity<ReceitaDTO> findById(Long id) {
        Optional<Receita> receitaOptional = receitaRepository.findById(id);
        return receitaOptional.map(receita -> ResponseEntity.ok(new ReceitaDTO(receita))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<ReceitaDTO> create(ReceitaDTO receitaDTO, UriComponentsBuilder uriBuilder) throws ReceitaExistenteException {
        Receita receita = new Receita(
                null,
                receitaDTO.getDescricao(),
                receitaDTO.getValor(),
                receitaDTO.getData());
        verificaSeReceitaExisteNoMes(receita);

        receitaRepository.save(receita);
        URI uri  = uriBuilder.path("/receitas/{id}").buildAndExpand(receita.getId()).toUri();
        return ResponseEntity.created(uri).body(new ReceitaDTO(receita));
    }

    public ResponseEntity<?> delete(Long id) {
        Optional<Receita> receitaOptional = receitaRepository.findById(id);
        if(receitaOptional.isPresent()){
            receitaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<ReceitaDTO> atualizar(Long id, ReceitaDTO receitaDTO) {
        Receita receita = new Receita(receitaDTO.getId(),
                receitaDTO.getDescricao(),
                receitaDTO.getValor(),
                receitaDTO.getData());
        verificaSeReceitaExisteNoMes(receita);

        Optional<Receita> receitaOptional = receitaRepository.findById(id);
        if(receitaOptional.isPresent()){
           Receita receitaAtual = receitaRepository.findById(receita).get();

            receita.setDescricao(receitaAtual.getDescricao());
            receita.setValor(receitaAtual.getValor());
            receita.setData(receitaAtual.getData());
            return ResponseEntity.ok(new ReceitaDTO(receita));
        }
        return ResponseEntity.notFound().build();
    }

    private void verificaSeReceitaExisteNoMes(Receita receita) {
        Optional<Receita> receitaEncontrada = receitaRepository.findByDescricaoAndData(receita.getDescricao(), receita.getData());
        if(receitaEncontrada.isPresent()) {
            throw new ReceitaExistenteException("Já existe uma receita cadastrada com a mesma descrição no mês informado");
        }
    }
}
