package com.mp.mparm.features.arma.repository;

import com.mp.mparm.features.agente.model.entity.Agente;
import com.mp.mparm.features.arma.model.entity.Arma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArmaRepository extends JpaRepository<Arma, Long> {

    boolean existsByNumeroSerie(String numSerie);

    //boolean existsByEmail(String email);

    List<Arma> findByDeletedAtIsNull();

    Optional<Arma> findByIdAndDeletedAtIsNull(Long id);

}
