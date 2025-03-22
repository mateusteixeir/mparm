package com.mp.mparm.features.agente.controller;

import com.mp.mparm.features.agente.converter.AgenteConverter;
import com.mp.mparm.features.agente.model.dto.AgenteDTO;
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
@RequestMapping("api/agentes")
public class AgenteController {

    @Autowired
    AgenteService agenteService;

    @PostMapping
    public ResponseEntity<Agente> cadastrarNovoAgente(@RequestBody @Valid AgenteDTO agenteCadDTO) {
        Agente agente = AgenteConverter.fromAgente(agenteCadDTO);
        Agente agenteCadastrado = agenteService.cadastrarAgente(agente);
        return ResponseEntity.status(HttpStatus.CREATED).body(agenteCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agente> atualizarAgente(@PathVariable Long id, @RequestBody AgenteDTO agenteCadDTO) {
        Agente agenteAtualizado = agenteService.atualizarAgente(id, agenteCadDTO);
        return ResponseEntity.ok(agenteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAgente(@PathVariable Long id) {
        agenteService.deletarAgente(id);
        return ResponseEntity.ok().body("Agente deletado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<AgenteListagemDTO>> listarAgentes() {
        return ResponseEntity.ok(agenteService.listarAgentes());
    }

}
