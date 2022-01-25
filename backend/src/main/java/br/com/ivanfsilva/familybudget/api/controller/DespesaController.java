package br.com.ivanfsilva.familybudget.api.controller;

import br.com.ivanfsilva.familybudget.api.dto.DespesaDTO;
import br.com.ivanfsilva.familybudget.api.dto.ReceitaDTO;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Despesa;
import br.com.ivanfsilva.familybudget.domain.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    DespesaService despesaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DespesaDTO> findById(@PathVariable Long id) {
        DespesaDTO dto = despesaService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<DespesaDTO>> findAll() {
        List<DespesaDTO> listDTO = despesaService.findAll();

        return ResponseEntity.ok().body(listDTO);
    }
}
