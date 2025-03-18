package com.mp.mparm.features.modeloArma.service;

import com.mp.mparm.features.modeloArma.model.dto.ModeloArmaDTO;
import com.mp.mparm.features.modeloArma.model.entity.ModeloArma;
import com.mp.mparm.features.calibre.model.entity.Calibre;
import com.mp.mparm.features.fabricante.model.entity.Fabricante;
import com.mp.mparm.features.modeloArma.repository.ModeloArmaRepository;
import com.mp.mparm.features.calibre.repository.CalibreRepository;
import com.mp.mparm.features.fabricante.repository.FabricanteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModeloArmaService {

    private final ModeloArmaRepository modeloArmaRepository;
    private final CalibreRepository calibreRepository;
    private final FabricanteRepository fabricanteRepository;

    // Método para criar um novo ModeloArma
    @Transactional
    public ModeloArma createModeloArma(ModeloArmaDTO modeloArmaDTO) {
        // Buscar o Calibre e Fabricante pelo ID
        Calibre calibre = calibreRepository.findById(modeloArmaDTO.calibreId())
                .orElseThrow(() -> new RuntimeException("Calibre não encontrado"));
        Fabricante fabricante = fabricanteRepository.findById(modeloArmaDTO.fabricanteId())
                .orElseThrow(() -> new RuntimeException("Fabricante não encontrado"));

        // Converter DTO para a entidade ModeloArma
        ModeloArma modeloArma = modeloArmaDTO.toEntity(calibre, fabricante);

        // Salvar no banco de dados
        return modeloArmaRepository.save(modeloArma);
    }

    // Método para buscar um ModeloArma por ID
    public Optional<ModeloArma> getModeloArma(Long id) {
        return modeloArmaRepository.findById(id);
    }

    // Método para listar todos os Modelos de Arma
    public Iterable<ModeloArma> getAllModelosArma() {
        return modeloArmaRepository.findAll();
    }
}
