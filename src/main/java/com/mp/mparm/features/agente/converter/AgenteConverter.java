package com.mp.mparm.features.agente.converter;

import com.mp.mparm.features.agente.model.dto.AgenteCadDTO;
import com.mp.mparm.features.agente.model.entity.Agente;
import org.aspectj.weaver.loadtime.Agent;

public class AgenteConverter {

    public static Agente fromAgente(AgenteCadDTO agenteCadDTO) {
        Agente agente = new Agente();
        agente.setNome(agenteCadDTO.nome());
        agente.setSobrenome(agenteCadDTO.sobrenome());
        agente.setCpf(agenteCadDTO.cpf());
        agente.setDataNascimento(agenteCadDTO.dataNascimento());
        agente.setEmail(agenteCadDTO.email());
        agente.setTelefone(agenteCadDTO.telefone());

        return  agente;
    }
}
