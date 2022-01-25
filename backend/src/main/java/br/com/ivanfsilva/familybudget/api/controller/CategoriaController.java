package br.com.ivanfsilva.familybudget.api.controller;

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

}
