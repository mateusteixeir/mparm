package com.mp.mparm.features.agente.repository;

import com.mp.mparm.features.agente.model.entity.Agente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgenteRepository extends JpaRepository<Agente, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    List<Agente> findByDeletedAtIsNull();

    Optional<Agente> findByIdAndDeletedAtIsNull(Long id);

}
