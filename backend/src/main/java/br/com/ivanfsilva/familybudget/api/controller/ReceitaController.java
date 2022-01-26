package br.com.ivanfsilva.familybudget.api.controller;

import br.com.ivanfsilva.familybudget.api.dto.ReceitaDTO;
import br.com.ivanfsilva.familybudget.domain.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    ReceitaService receitaService;

    @GetMapping
    public ResponseEntity<List<ReceitaDTO>> findAll() {
        List<ReceitaDTO> listDTO = receitaService.findAll();
        return ResponseEntity.ok().body( listDTO );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaDTO> findById(@PathVariable Long id){
        return receitaService.findById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ReceitaDTO> create(@RequestBody @Valid ReceitaDTO receitaDTO, UriComponentsBuilder uriBuilder) {
        return receitaService.create(receitaDTO, uriBuilder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ReceitaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ReceitaDTO receitaDTO){
        return receitaService.atualizar(id, receitaDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        return receitaService.delete(id);
    }
}
