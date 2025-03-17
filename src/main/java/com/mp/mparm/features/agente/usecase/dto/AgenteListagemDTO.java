package com.mp.mparm.features.agente.usecase.dto;

import com.mp.mparm.features.agente.model.entity.AgenteEntity;

public record AgenteListagemDTO(
        Long id,
        String nome,
        String sobrenome,
        String cpf,
        String email,
        String telefone) {
    public AgenteListagemDTO (AgenteEntity agente) {
        this(agente.getId(), agente.getNome(), agente.getSobrenome(), agente.getCpf(), agente.getEmail(), agente.getTelefone());
    }
}
