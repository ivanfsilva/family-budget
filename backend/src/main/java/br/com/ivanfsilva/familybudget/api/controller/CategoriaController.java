package br.com.ivanfsilva.familybudget.api.controller;

import br.com.ivanfsilva.familybudget.api.dto.CategoriaDTO;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Categoria;
import br.com.ivanfsilva.familybudget.domain.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id ) {
        Categoria obj = service.findById( id );

        return ResponseEntity.ok().body( obj );
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = service.findAll();
        List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO( obj )).collect( Collectors.toList() );

        return ResponseEntity.ok().body( listDTO );
    }

    @PostMapping
    public ResponseEntity<Categoria> create( @Valid @RequestBody Categoria obj ) {
        obj = service.create( obj );
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path( "/{id}" ).buildAndExpand( obj.getId() ).toUri();

        return ResponseEntity.created( uri ).body( obj );
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> update( @Valid @PathVariable Integer id, @RequestBody CategoriaDTO objDTO ) {
        Categoria newObj = service.update( id, objDTO );

        return ResponseEntity.ok().body( new CategoriaDTO(newObj) );
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete( @PathVariable Integer id ) {
        service.delete( id );
        return ResponseEntity.noContent().build();
    }
}
