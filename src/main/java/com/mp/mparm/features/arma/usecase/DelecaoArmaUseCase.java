package com.mp.mparm.features.arma.usecase;

import com.mp.mparm.features.arma.model.entity.Arma;
import com.mp.mparm.features.arma.repository.ArmaRepository;

import java.time.LocalDateTime;

public class DelecaoArmaUseCase {
    private final ArmaRepository repository;

    public DelecaoArmaUseCase(ArmaRepository repository) {
        this.repository = repository;
    }

    public void executarDelecaoArma(Long id){
        Arma arma = repository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new RuntimeException("Arma não encontrado"));

        arma.setDeletedAt(LocalDateTime.now());
        repository.save(arma);
    }
}
