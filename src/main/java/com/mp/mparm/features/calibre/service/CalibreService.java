package com.mp.mparm.features.calibre.service;

import com.mp.mparm.features.calibre.converter.CalibreConverter;
import com.mp.mparm.features.calibre.model.dto.CalibreDTO;
import com.mp.mparm.features.calibre.model.dto.CalibreListagemDTO;
import com.mp.mparm.features.calibre.model.entity.Calibre;
import com.mp.mparm.features.calibre.repository.CalibreRepository;
import com.mp.mparm.features.calibre.usecase.CadastroCalibreUseCase;
import com.mp.mparm.features.exception.DuplicateResourceException;
import com.mp.mparm.features.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CalibreService {

    @Autowired
    private CalibreRepository calibreRepository;

    @Transactional
    public Calibre cadastrarCalibre(Calibre calibre) {

        CadastroCalibreUseCase cadastroCalibreUseCase = new CadastroCalibreUseCase(calibreRepository);

        return cadastroCalibreUseCase.executarCriacaoCalibre(calibre);
    }

    @Transactional
    public Calibre atualizarCalibre(Long id, CalibreDTO calibreCadDTO){

        if (calibreRepository.existsByDescricao(calibreCadDTO.descricao())) {
            throw new DuplicateResourceException("Calibre já cadastrado");
        }

        Calibre calibre = CalibreConverter.fromCalibre(calibreCadDTO);
        Calibre calibreAtualizado = calibreRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calibre com ID" + id + " não encontrado"));

        if (calibre.getDescricao() != null) {
            calibreAtualizado.setDescricao(calibre.getDescricao());
        }

        return calibreRepository.save(calibreAtualizado);
    }

    @Transactional
    public void deletarCalibre(Long id) {

        Calibre calibre = calibreRepository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new ResourceNotFoundException("Calibre com ID" + id + " não encontrado"));
        calibre.setDeletedAt(LocalDateTime.now());
        calibreRepository.save(calibre);
    }

    public List<CalibreListagemDTO> listarCalibres() {
        return calibreRepository.findByDeletedAtIsNull().stream().map(CalibreListagemDTO::new).toList();
    }

}
