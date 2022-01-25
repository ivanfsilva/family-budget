package br.com.ivanfsilva.familybudget.domain.service;

import br.com.ivanfsilva.familybudget.api.dto.DespesaDTO;
import br.com.ivanfsilva.familybudget.domain.model.orcamento.Despesa;
import br.com.ivanfsilva.familybudget.domain.repository.DespesaCategory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class DespesaService {

    @Autowired
    private DespesaCategory despesaCategory;

    public List<DespesaDTO> findAll() {
        List<Despesa> list = despesaCategory.findAll();
        List<DespesaDTO> listDTO = list.stream().map( d -> new DespesaDTO(d)).collect(Collectors.toList());

        return listDTO;
    }
}
