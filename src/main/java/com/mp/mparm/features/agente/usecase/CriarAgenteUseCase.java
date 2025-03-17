package com.mp.mparm.features.agente.usecase;

import com.mp.mparm.features.agente.model.domain.Agente;
import com.mp.mparm.features.agente.repository.IAgenteRepository;
import com.mp.mparm.features.agente.usecase.dto.AgenteCadDTO;
import com.mp.mparm.features.exception.DuplicateResourceException;

public class CriarAgenteUseCase {

    private final IAgenteRepository agenteRepository;

    public CriarAgenteUseCase(IAgenteRepository agenteRepository) {
        this.agenteRepository = agenteRepository;
    }

    public void executarCriacao(AgenteCadDTO agenteCadDTO){
        Agente agente =  Agente.criarAgente(agenteCadDTO.nome(), agenteCadDTO.sobrenome(), agenteCadDTO.cpf(), agenteCadDTO.dataNascimento(), agenteCadDTO.email(), agenteCadDTO.telefone());

        if(agenteRepository.existsByCpf(agente.getCpf())){
            throw new DuplicateResourceException("CPF já cadastrado");
        }
        if(agenteRepository.existsByEmail(agente.getEmail())){
            throw new DuplicateResourceException("EMAIL já cadastra");
        }


        agenteRepository.save(agente);
    }
}
