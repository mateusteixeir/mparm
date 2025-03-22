package com.mp.mparm.features.fabricante.service;

import com.mp.mparm.features.exception.DuplicateResourceException;
import com.mp.mparm.features.exception.ResourceNotFoundException;
import com.mp.mparm.features.fabricante.converter.FabricanteConverter;
import com.mp.mparm.features.fabricante.model.dto.FabricanteCadDTO;
import com.mp.mparm.features.fabricante.model.dto.FabricanteListagemDTO;
import com.mp.mparm.features.fabricante.model.entity.Fabricante;
import com.mp.mparm.features.fabricante.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;



    @Transactional
    public Fabricante cadastrarFabricante(Fabricante fabricante) {
        if(fabricanteRepository.existsByCnpj(fabricante.getCnpj())){
            throw new DuplicateResourceException("Fabricante já cadastrado");
        }

        return fabricanteRepository.save(fabricante);
    }

    @Transactional
    public Fabricante atualizarFabricante(Long id, FabricanteCadDTO fabricanteCadDTO){

        if (fabricanteRepository.existsByCnpj(fabricanteCadDTO.cnpj())) {
            throw new DuplicateResourceException("Fabricante já cadastrado");
        }

        Fabricante fabricante = FabricanteConverter.fromFabricante(fabricanteCadDTO);
        Fabricante fabricanteAtualizado = fabricanteRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fabricante com ID" + id + " não encontrado"));

        if (fabricante.getCnpj() != null) {
            fabricanteAtualizado.setCnpj(fabricante.getCnpj());
        }

        if (fabricante.getNome() != null) {
            fabricanteAtualizado.setNome(fabricante.getNome());
        }

        return fabricanteRepository.save(fabricanteAtualizado);
    }


    public List<FabricanteListagemDTO> listarFabricantes() {
        return fabricanteRepository.findByDeletedAtIsNull().stream().map(FabricanteListagemDTO::new).toList();
    }

    @Transactional
    public void deletarFabricante(Long id) {
        Fabricante fabricante = fabricanteRepository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new ResourceNotFoundException("Fabricante com ID" + id + " não encontrado"));
        fabricante.setDeletedAt(LocalDateTime.now());
        fabricanteRepository.save(fabricante);
    }

}
