package com.mp.mparm.features.agente.usecase;

import com.mp.mparm.features.agente.model.entity.Agente;
import com.mp.mparm.features.agente.repository.AgenteRepository;
import com.mp.mparm.features.exception.DuplicateResourceException;

public class CriarAgenteUseCase {

    private final AgenteRepository repository;

    public CriarAgenteUseCase(AgenteRepository repository) {
        this.repository = repository;
    }

    public Agente executarCriacaoAgente(Agente agente){

        if(repository.existsByCpf(agente.getCpf())){
            throw new DuplicateResourceException("CPF já cadastrado");
        }
        if(repository.existsByEmail(agente.getEmail())){
            throw new DuplicateResourceException("EMAIL já cadastra");
        }

        return repository.save(agente);
    }
}
