package com.mp.mparm.features.calibre.controller;

import com.mp.mparm.features.calibre.model.dto.CalibreCadDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calibres")
public class CalibreController {

    @PostMapping
    public CalibreCadDTO cadastrarNovoCalibre(@RequestBody CalibreCadDTO cadastroCalibreDTO) {
        System.out.println(cadastroCalibreDTO);
        return cadastroCalibreDTO;
    }
}
