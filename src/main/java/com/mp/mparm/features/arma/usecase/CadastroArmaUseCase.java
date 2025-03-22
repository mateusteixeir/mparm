package com.mp.mparm.features.arma.usecase;

import com.mp.mparm.features.arma.model.dto.ArmaDTO;
import com.mp.mparm.features.arma.model.entity.Arma;
import com.mp.mparm.features.arma.repository.ArmaRepository;
import com.mp.mparm.features.calibre.repository.CalibreRepository;
import com.mp.mparm.features.fabricante.repository.FabricanteRepository;
import com.mp.mparm.features.modeloArma.repository.ModeloArmaRepository;

public class CadastroArmaUseCase {
    private final ArmaRepository armaRepository;
    private final ModeloArmaRepository modeloArmaRepository;
    private final CalibreRepository calibreRepository;
    private final FabricanteRepository fabricanteRepository;

    public CadastroArmaUseCase(ArmaRepository armaRepository, ModeloArmaRepository modeloArmaRepository, CalibreRepository calibreRepository, FabricanteRepository fabricanteRepository) {
        this.armaRepository = armaRepository;
        this.modeloArmaRepository = modeloArmaRepository;
        this.calibreRepository = calibreRepository;
        this.fabricanteRepository = fabricanteRepository;
    }

    public Arma executarCriacaoArma(ArmaDTO dto){

        var modelo = modeloArmaRepository.findById(dto.modeloId())
                .orElseThrow(() -> new IllegalArgumentException("Modelo não encontrado"));

        var calibre = calibreRepository.findById(dto.calibreId())
                .orElseThrow(() -> new IllegalArgumentException("Calibre não encontrado"));

        var fabricante = fabricanteRepository.findById(dto.fabricanteId())
                .orElseThrow(() -> new IllegalArgumentException("Fabricante não encontrado"));


        Arma arma = new Arma(null, modelo, calibre, fabricante, dto.numeroSerie(), null, null, null);

        return armaRepository.save(arma);
    }
}
