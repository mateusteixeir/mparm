package com.mp.mparm.features.arma.controller;

import com.mp.mparm.features.arma.model.dto.ArmaDTO;
import com.mp.mparm.features.arma.model.entity.Arma;
import com.mp.mparm.features.arma.service.ArmaService;
import com.mp.mparm.features.arma.usecase.ListagemArmaUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/armas")
@RequiredArgsConstructor
public class ArmaController {

    private final ArmaService armaService;

    @GetMapping
    public ResponseEntity<List<Arma>> listar() {
        return ResponseEntity.ok(armaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arma> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(armaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Arma> salvar(@RequestBody @Valid ArmaDTO dto) {

        return ResponseEntity.ok(armaService.salvar(dto));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deletar(@PathVariable Long id) {
        armaService.deletar(id);

        return ResponseEntity.ok().body("Arma deletada com sucesso!");
    }
}
