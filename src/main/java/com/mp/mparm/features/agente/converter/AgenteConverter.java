package com.mp.mparm.features.agente.converter;

import com.mp.mparm.features.agente.model.dto.AgenteDTO;
import com.mp.mparm.features.agente.model.entity.Agente;

public class AgenteConverter {

    public static Agente fromAgente(AgenteDTO agenteCadDTO) {
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
