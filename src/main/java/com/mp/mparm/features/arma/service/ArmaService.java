package com.mp.mparm.features.arma.service;

import com.mp.mparm.features.arma.model.dto.ArmaDTO;
import com.mp.mparm.features.arma.model.entity.Arma;
import com.mp.mparm.features.arma.repository.ArmaRepository;
import com.mp.mparm.features.calibre.repository.CalibreRepository;
import com.mp.mparm.features.fabricante.repository.FabricanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArmaService {

    private final ArmaRepository armaRepository;
    private final CalibreRepository calibreRepository;
    private final FabricanteRepository fabricanteRepository;

    public List<Arma> listar() {
        return armaRepository.findAll();
    }

    public Optional<Arma> buscarPorId(Long id) {
        return armaRepository.findById(id);
    }

    public Arma salvar(ArmaDTO dto) {
        var calibre = calibreRepository.findById(dto.calibreId())
                .orElseThrow(() -> new IllegalArgumentException("Calibre não encontrado"));

        var fabricante = fabricanteRepository.findById(dto.fabricanteId())
                .orElseThrow(() -> new IllegalArgumentException("Fabricante não encontrado"));

        Arma arma = new Arma(null, dto.modelo(), calibre, fabricante, dto.numeroSerie(), null, null, null);
        return armaRepository.save(arma);
    }

    public void deletar(Long id) {
        armaRepository.deleteById(id);
    }
}
