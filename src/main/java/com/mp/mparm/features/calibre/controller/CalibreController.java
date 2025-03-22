package com.mp.mparm.features.calibre.controller;

import com.mp.mparm.features.calibre.converter.CalibreConverter;
import com.mp.mparm.features.calibre.model.dto.CalibreDTO;
import com.mp.mparm.features.calibre.model.dto.CalibreListagemDTO;
import com.mp.mparm.features.calibre.model.entity.Calibre;
import com.mp.mparm.features.calibre.service.CalibreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/calibres")
public class CalibreController {

    @Autowired
    CalibreService calibreService;

    @PostMapping
    public ResponseEntity<Calibre> cadastrarNovoCalibre(@RequestBody @Valid CalibreDTO cadastroCalibreDTO) {
        Calibre calibre = CalibreConverter.fromCalibre(cadastroCalibreDTO);
        Calibre calibreCadastrado = calibreService.cadastrarCalibre(calibre);
        return ResponseEntity.status(HttpStatus.CREATED).body(calibreCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calibre> atualizarCalibre(@PathVariable Long id, @RequestBody CalibreDTO CalibreCadDTO) {
        Calibre calibreAtualizado = calibreService.atualizarCalibre(id, CalibreCadDTO);
        return ResponseEntity.ok(calibreAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCalibre(@PathVariable Long id) {
        calibreService.deletarCalibre(id);
        return ResponseEntity.ok("Agente deletado logicamente com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<CalibreListagemDTO>> listarAgentes() {
        List<CalibreListagemDTO> calibres = calibreService.listarCalibres();
        return ResponseEntity.ok(calibres);
    }
}
