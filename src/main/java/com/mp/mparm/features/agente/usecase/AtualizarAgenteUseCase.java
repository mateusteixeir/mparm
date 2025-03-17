package com.mp.mparm.features.agente.usecase;

import com.mp.mparm.features.agente.model.domain.Agente;
import com.mp.mparm.features.agente.repository.AgenteRepository;
import com.mp.mparm.features.agente.repository.IAgenteRepository;
import com.mp.mparm.features.agente.usecase.dto.AgenteCadDTO;
import com.mp.mparm.features.exception.DuplicateResourceException;

public class AtualizarAgenteUseCase {

    private final IAgenteRepository agenteRepository;

    public AtualizarAgenteUseCase(IAgenteRepository agenteRepository) {
        this.agenteRepository = agenteRepository;
    }

    public void executarAtualizacao(Long id, AgenteCadDTO agenteCadDTO){
        if (agenteRepository.existsByCpf(agenteCadDTO.cpf())) {
            throw new DuplicateResourceException("Já existe um agente com este CPF.");
        }

        if (agenteRepository.existsByEmail(agenteCadDTO.email())) {
            throw new DuplicateResourceException("Já existe um agente com este email.");
        }

        Agente Agente = new Agente();

    }
}
