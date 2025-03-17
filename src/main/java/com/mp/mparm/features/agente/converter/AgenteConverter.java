package com.mp.mparm.features.agente.converter;

import com.mp.mparm.features.agente.model.domain.Agente;
import com.mp.mparm.features.agente.usecase.dto.AgenteCadDTO;
import com.mp.mparm.features.agente.model.entity.AgenteEntity;

public class AgenteConverter {

    public AgenteEntity domainToEntity(Agente agente) {
        AgenteEntity agenteEntity = new AgenteEntity();
        agenteEntity.setNome(agente.getNome());
        agenteEntity.setSobrenome(agente.getSobrenome());
        agenteEntity.setCpf(agente.getCpf());
        agenteEntity.setDataNascimento(agente.getDataNascimento());
        agenteEntity.setEmail(agente.getEmail());
        agenteEntity.setTelefone(agente.getTelefone());

        return  agenteEntity;
    }

    public  Agente entityToDomain(AgenteEntity agenteEntity){
        return new Agente(agenteEntity.getId(), agenteEntity.getNome(), agenteEntity.getSobrenome(), agenteEntity.getCpf(), agenteEntity.getDataNascimento(), agenteEntity.getEmail(), agenteEntity.getTelefone());

    }

    public static AgenteCadDTO domainToDTO(Agente agente){

        return new AgenteCadDTO(agente.getNome(), agente.getSobrenome(), agente.getCpf(), agente.getDataNascimento(), agente.getEmail(), agente.getTelefone());

    }

    public static AgenteCadDTO entityToDTO(AgenteEntity agenteEntity){

        return new AgenteCadDTO(agenteEntity.getNome(), agenteEntity.getSobrenome(), agenteEntity.getCpf(), agenteEntity.getDataNascimento(), agenteEntity.getEmail(), agenteEntity.getTelefone());

    }
}
