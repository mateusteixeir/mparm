package com.mp.mparm.features.agente.controller;

import com.mp.mparm.features.agente.converter.AgenteConverter;
import com.mp.mparm.features.agente.model.dto.AgenteCadDTO;
import com.mp.mparm.features.agente.model.dto.AgenteListagemDTO;
import com.mp.mparm.features.agente.model.entity.Agente;
import com.mp.mparm.features.agente.service.AgenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agentes")
public class AgenteController {

    @Autowired
    AgenteService agenteService;

    @PostMapping
    public ResponseEntity<Agente> cadastrarNovoAgente(@RequestBody @Valid AgenteCadDTO agenteCadDTO) {
        Agente agente = AgenteConverter.fromAgente(agenteCadDTO);
        Agente agenteCadastrado = agenteService.cadastrarAgente(agente);
        return ResponseEntity.status(HttpStatus.CREATED).body(agenteCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agente> atualizarAgente(@PathVariable Long id, @RequestBody AgenteCadDTO agenteCadDTO) {
        Agente agenteAtualizado = agenteService.atualizarAgente(id, agenteCadDTO);
        return ResponseEntity.ok(agenteAtualizado);
    }

    @DeleteMapping("/{id}")
    public String deletarAgente(@PathVariable Long id) {
        agenteService.deletarAgente(id);
        return "Agente deletado logicamente com sucesso!";
    }

    @GetMapping
    public ResponseEntity<List<AgenteListagemDTO>> listarAgentes() {
        List<AgenteListagemDTO> agentes = agenteService.listarAgentes();
        return ResponseEntity.ok(agentes);
    }

}
