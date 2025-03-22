package com.mp.mparm.features.agente.usecase;

import com.mp.mparm.features.agente.model.entity.Agente;
import com.mp.mparm.features.agente.repository.AgenteRepository;

import java.time.LocalDateTime;

public class DeletarAgenteUseCase {

    private final AgenteRepository repository;

    public DeletarAgenteUseCase(AgenteRepository repository) {
        this.repository = repository;
    }

    public void executarDelecaoAgente(Long id){

        Agente agente = repository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new RuntimeException("Agente não encontrado"));

        agente.setDeletedAt(LocalDateTime.now());
        repository.save(agente);
    }
}
