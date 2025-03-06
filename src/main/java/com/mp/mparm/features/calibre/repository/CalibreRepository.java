package com.mp.mparm.features.calibre.repository;

import com.mp.mparm.features.calibre.model.entity.Calibre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CalibreRepository extends JpaRepository<Calibre, Long> {

    boolean existsByDescricao(String descricao);

    List<Calibre> findByDeletedAtIsNull();

    Optional<Calibre> findByIdAndDeletedAtIsNull(Long id);
}
