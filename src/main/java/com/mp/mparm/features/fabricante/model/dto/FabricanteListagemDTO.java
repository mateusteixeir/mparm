package com.mp.mparm.features.fabricante.model.dto;

import com.mp.mparm.features.fabricante.model.entity.Fabricante;

public record FabricanteListagemDTO(Long id, String nome, String cnpj) {
    public FabricanteListagemDTO (Fabricante fabricante){
        this(fabricante.getId(), fabricante.getNome(), fabricante.getCnpj());
    }
}
