package com.mp.mparm.features.agente.usecase;

import com.mp.mparm.features.agente.converter.AgenteConverter;
import com.mp.mparm.features.agente.model.dto.AgenteDTO;
import com.mp.mparm.features.agente.model.entity.Agente;
import com.mp.mparm.features.agente.repository.AgenteRepository;
import com.mp.mparm.features.exception.DuplicateResourceException;

public class AtualizarAgenteUseCase {

    private final AgenteRepository repository;


    public AtualizarAgenteUseCase(AgenteRepository repository) {
        this.repository = repository;
    }

    public Agente executarAtualizacaoAgente(Long id, AgenteDTO agenteCadDTO){

        if (repository.existsByCpf(agenteCadDTO.cpf())) {
            throw new DuplicateResourceException("Já existe um agente com este CPF.");
        }

        if (repository.existsByEmail(agenteCadDTO.email())) {
            throw new DuplicateResourceException("Já existe um agente com este email.");
        }

        Agente agente = AgenteConverter.fromAgente(agenteCadDTO);

        Agente agenteAtualizado = repository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new IllegalArgumentException("Agente não encontrado"));

        if (agente.getNome() != null) {
            agenteAtualizado.setNome(agente.getNome());
        }
        if (agente.getSobrenome() != null) {
            agenteAtualizado.setSobrenome(agente.getSobrenome());
        }
        if (agente.getCpf() != null) {
            agenteAtualizado.setCpf(agente.getCpf());
        }
        if (agente.getDataNascimento() != null) {
            agenteAtualizado.setDataNascimento(agente.getDataNascimento());
        }
        if (agente.getEmail() != null) {
            agenteAtualizado.setEmail(agente.getEmail());
        }
        if (agente.getTelefone() != null) {
            agenteAtualizado.setTelefone(agente.getTelefone());
        }

        return repository.save(agenteAtualizado);
    }
}
