package com.mp.mparm.features.calibre.usecase;

import com.mp.mparm.features.calibre.model.entity.Calibre;
import com.mp.mparm.features.calibre.repository.CalibreRepository;
import com.mp.mparm.features.exception.DuplicateResourceException;

public class CadastroCalibreUseCase {

    private final CalibreRepository repository;

    public CadastroCalibreUseCase(CalibreRepository repository) {
        this.repository = repository;
    }

    public Calibre executarCriacaoCalibre(Calibre calibre){
        if(repository.existsByDescricao(calibre.getDescricao())){
            throw new DuplicateResourceException("Calibre já cadastrado!");
        }


     return repository.save(calibre);
    }
}
