package br.com.ivanfsilva.familybudget.api.controller;

import br.com.ivanfsilva.familybudget.api.dto.DespesaDTO;
import br.com.ivanfsilva.familybudget.domain.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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

    @PostMapping
    public ResponseEntity<DespesaDTO> insert(@Valid @RequestBody DespesaDTO dto) {
        dto = despesaService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DespesaDTO> update(@Valid @PathVariable Long id, @RequestBody DespesaDTO dto) {
        dto = despesaService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        despesaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
