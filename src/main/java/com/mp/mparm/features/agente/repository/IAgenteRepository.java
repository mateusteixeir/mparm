package com.mp.mparm.features.agente.repository;

import com.mp.mparm.features.agente.model.domain.Agente;
import java.util.List;
import java.util.Optional;

public interface IAgenteRepository {

    void save(Agente agente);

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    List<Agente> findByDeletedAtIsNull();

    Optional<Agente> findByIdAndDeletedAtIsNull(Long id);

}
