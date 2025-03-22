package com.mp.mparm.features.agente.usecase;

import com.mp.mparm.features.agente.model.dto.AgenteListagemDTO;
import com.mp.mparm.features.agente.model.entity.Agente;
import com.mp.mparm.features.agente.repository.AgenteRepository;

import java.util.List;

public class ListarAgenteUseCase {

    private final AgenteRepository repository;

    public ListarAgenteUseCase(AgenteRepository repository) {
        this.repository = repository;
    }

    public List<AgenteListagemDTO> executarListagem(){

        return repository.findByDeletedAtIsNull().stream().map(AgenteListagemDTO::new).toList();
    }
}
