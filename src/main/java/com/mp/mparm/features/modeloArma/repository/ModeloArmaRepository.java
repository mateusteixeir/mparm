package com.mp.mparm.features.modeloArma.repository;

import com.mp.mparm.features.modeloArma.model.entity.ModeloArma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloArmaRepository extends JpaRepository<ModeloArma, Long> {
}
