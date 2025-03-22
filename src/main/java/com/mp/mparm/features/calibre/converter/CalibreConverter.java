package com.mp.mparm.features.calibre.converter;

import com.mp.mparm.features.calibre.model.dto.CalibreDTO;
import com.mp.mparm.features.calibre.model.entity.Calibre;

public class CalibreConverter {

    public static Calibre fromCalibre(CalibreDTO calibreCadDTO) {
        Calibre calibre = new Calibre();
        calibre.setDescricao(calibreCadDTO.descricao());

        return calibre;
    }
}
