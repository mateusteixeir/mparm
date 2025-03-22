package com.mp.mparm.features.arma.usecase;

import com.mp.mparm.features.agente.usecase.ListarAgenteUseCase;
import com.mp.mparm.features.arma.model.entity.Arma;
import com.mp.mparm.features.arma.repository.ArmaRepository;
import com.mp.mparm.features.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public class ListagemArmaUseCase {

    private final ArmaRepository repository;

    public ListagemArmaUseCase(ArmaRepository repository) {
        this.repository = repository;
    }

    public List<Arma> executarListagemArmas(){

        return repository.findAll();
    }

    public Arma pesquisarArmaPorID(Long id){

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Arma não encontrada"));
    }
}
