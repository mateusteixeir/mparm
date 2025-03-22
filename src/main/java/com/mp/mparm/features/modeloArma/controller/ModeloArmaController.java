package com.mp.mparm.features.modeloArma.controller;

import com.mp.mparm.features.modeloArma.model.dto.ModeloArmaDTO;
import com.mp.mparm.features.modeloArma.model.entity.ModeloArma;
import com.mp.mparm.features.modeloArma.service.ModeloArmaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/modeloarma")
@RequiredArgsConstructor
public class ModeloArmaController {

    private final ModeloArmaService modeloArmaService;

    @PostMapping
    public ResponseEntity<ModeloArma> createModeloArma(@RequestBody @Valid ModeloArmaDTO modeloArmaDTO) {
        ModeloArma modeloArma = modeloArmaService.createModeloArma(modeloArmaDTO);
        return new ResponseEntity<>(modeloArma, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloArma> getModeloArma(@PathVariable Long id) {
        return modeloArmaService.getModeloArma(id)
                .map(modeloArma -> new ResponseEntity<>(modeloArma, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<ModeloArma>> getAllModelosArma() {
        Iterable<ModeloArma> modelosArma = modeloArmaService.getAllModelosArma();
        return new ResponseEntity<>(modelosArma, HttpStatus.OK);
    }
}
