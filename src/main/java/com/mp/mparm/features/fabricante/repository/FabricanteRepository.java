package com.mp.mparm.features.fabricante.repository;

import com.mp.mparm.features.fabricante.model.entity.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

    boolean existsByCnpj(String cnpj);
    List<Fabricante> findByDeletedAtIsNull();
    Optional<Fabricante> findByIdAndDeletedAtIsNull(Long id);
}
