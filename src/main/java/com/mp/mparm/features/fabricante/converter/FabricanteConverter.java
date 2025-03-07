package com.mp.mparm.features.fabricante.converter;

import com.mp.mparm.features.fabricante.model.dto.FabricanteCadDTO;
import com.mp.mparm.features.fabricante.model.entity.Fabricante;

public class FabricanteConverter {

    public static Fabricante fromFabricante(FabricanteCadDTO fabricanteCadDTO){
        Fabricante fabricante = new Fabricante();
        fabricante.setNome(fabricanteCadDTO.nome());
        fabricante.setCnpj(fabricanteCadDTO.cnpj());
        return fabricante;
    }
}
