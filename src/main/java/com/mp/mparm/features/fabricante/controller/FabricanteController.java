package com.mp.mparm.features.fabricante.controller;



import com.mp.mparm.features.fabricante.converter.FabricanteConverter;
import com.mp.mparm.features.fabricante.model.dto.FabricanteCadDTO;
import com.mp.mparm.features.fabricante.model.dto.FabricanteListagemDTO;
import com.mp.mparm.features.fabricante.model.entity.Fabricante;
import com.mp.mparm.features.fabricante.service.FabricanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/fabricantes")
public class FabricanteController {

    @Autowired
    FabricanteService fabricanteService;

    @PostMapping
    public ResponseEntity<Fabricante> cadastrarFabricante(@RequestBody @Valid  FabricanteCadDTO fabricanteCadDTO) {
        Fabricante fabricante = FabricanteConverter.fromFabricante(fabricanteCadDTO);
        Fabricante fabricanteCadastrado = fabricanteService.cadastrarFabricante(fabricante);
        return ResponseEntity.status(HttpStatus.CREATED).body(fabricanteCadastrado);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> atualizarFabricante(@PathVariable Long id, @RequestBody FabricanteCadDTO fabricanteCadDTO) {
        Fabricante fabricanteAtualizado = fabricanteService.atualizarFabricante(id, fabricanteCadDTO);
        return ResponseEntity.ok(fabricanteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarFabricante(@PathVariable Long id) {
        fabricanteService.deletarFabricante(id);
        return ResponseEntity.ok("Agente deletado logicamente com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<FabricanteListagemDTO>> listarFabricantes() {
        List<FabricanteListagemDTO> fabricantes = fabricanteService.listarFabricantes();
        return ResponseEntity.ok(fabricantes);
    }

}
