package com.mp.mparm.features.arma.repository;

import com.mp.mparm.features.arma.model.entity.Arma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmaRepository extends JpaRepository<Arma, Long> {
}
