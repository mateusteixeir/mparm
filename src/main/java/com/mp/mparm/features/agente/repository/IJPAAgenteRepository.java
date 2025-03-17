package com.mp.mparm.features.agente.repository;

import com.mp.mparm.features.agente.model.entity.AgenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IJPAAgenteRepository extends JpaRepository<AgenteEntity, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    List<AgenteEntity> findByDeletedAtIsNull();

    Optional<AgenteEntity> findByIdAndDeletedAtIsNull(Long id);

}
