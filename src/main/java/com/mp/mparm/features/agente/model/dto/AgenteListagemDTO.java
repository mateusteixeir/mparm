package com.mp.mparm.features.agente.model.dto;

import com.mp.mparm.features.agente.model.entity.Agente;

public record AgenteListagemDTO(
        Long id,
        String nome,
        String sobrenome,
        String cpf,
        String email,
        String telefone) {
    public AgenteListagemDTO (Agente agente) {
        this(agente.getId(), agente.getNome(), agente.getSobrenome(), agente.getCpf(), agente.getEmail(), agente.getTelefone());
    }
}
