package com.mp.mparm.features.agente.controller;

import com.mp.mparm.features.agente.model.dto.AgenteCadDTO;
import com.mp.mparm.features.agente.model.entity.Agente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("agentes")
public class AgenteController {

    @PostMapping
    public ResponseEntity<Agente> cadastrarNovoAgente(@RequestBody AgenteCadDTO agenteCadDTO) {

        System.out.println(agenteCadDTO);
        return ResponseEntity.ok().build();

    }
}
