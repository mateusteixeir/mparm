package com.mp.mparm.features.agente.service;

import com.mp.mparm.features.agente.model.entity.Agente;
import com.mp.mparm.features.agente.repository.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgenteService {

    @Autowired
    private AgenteRepository agenteRepository;

    @Transactional
    public Agente cadastrarAgente(Agente agente){
        return agenteRepository.save(agente);

    }


}
