package com.mp.mparm.features.calibre.model.dto;

import com.mp.mparm.features.calibre.model.entity.Calibre;

public record CalibreListagemDTO(Long id, String nome) {
    public CalibreListagemDTO(Calibre calibre) {
        this(calibre.getId(), calibre.getDescricao());
    }
}
