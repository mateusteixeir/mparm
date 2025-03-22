package com.mp.mparm.features.calibre.repository;

import com.mp.mparm.features.calibre.converter.CalibreConverter;
import com.mp.mparm.features.calibre.model.dto.CalibreDTO;
import com.mp.mparm.features.calibre.model.entity.Calibre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ActiveProfiles("test")
class CalibreRepositoryTest {

    @Autowired
    CalibreRepository calibreRepository;

    @Test
    void existsByDescricao() {
        CalibreDTO calibreCadDTO = new CalibreDTO(".40");
        Calibre calibre = this.salvarCalibre(calibreCadDTO);

        assertTrue(calibreRepository.existsByDescricao(calibre.getDescricao()));
    }

    @Test
    void findByDeletedAtIsNull() {
    }

    @Test
    void findByIdAndDeletedAtIsNull() {
    }


    private Calibre salvarCalibre(CalibreDTO dtoCalibre){
        Calibre calibre = CalibreConverter.fromCalibre(dtoCalibre);
        calibreRepository.save(calibre);
        return calibre;
    }
}