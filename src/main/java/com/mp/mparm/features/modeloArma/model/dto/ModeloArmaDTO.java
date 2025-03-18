package com.mp.mparm.features.modeloArma.model.dto;

import com.mp.mparm.features.calibre.model.entity.Calibre;
import com.mp.mparm.features.fabricante.model.entity.Fabricante;
import com.mp.mparm.features.modeloArma.model.entity.ModeloArma;

public record ModeloArmaDTO(
        Long id,
        String descricao,
        Long calibreId,
        Long fabricanteId
) {
    // Método para converter DTO para a entidade ModeloArma
    public ModeloArma toEntity(Calibre calibre, Fabricante fabricante) {
        ModeloArma modeloArma = new ModeloArma();
        modeloArma.setId(this.id());
        modeloArma.setDescricao(this.descricao());
        modeloArma.setCalibre(calibre);
        modeloArma.setFabricante(fabricante);
        return modeloArma;
    }
}
