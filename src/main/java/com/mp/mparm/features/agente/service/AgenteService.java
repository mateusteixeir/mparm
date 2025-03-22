package com.mp.mparm.features.agente.service;

import com.mp.mparm.features.agente.usecase.AtualizarAgenteUseCase;
import com.mp.mparm.features.agente.usecase.CriarAgenteUseCase;
import com.mp.mparm.features.agente.model.dto.AgenteDTO;
import com.mp.mparm.features.agente.model.dto.AgenteListagemDTO;
import com.mp.mparm.features.agente.model.entity.Agente;
import com.mp.mparm.features.agente.repository.AgenteRepository;
import com.mp.mparm.features.agente.usecase.DeletarAgenteUseCase;
import com.mp.mparm.features.agente.usecase.ListarAgenteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgenteService {

    @Autowired
    private AgenteRepository agenteRepository;

    @Transactional
    public Agente cadastrarAgente(Agente agente) {
        CriarAgenteUseCase criarAgenteUseCase = new CriarAgenteUseCase(agenteRepository);
        return criarAgenteUseCase.executarCriacaoAgente(agente);
    }

    @Transactional
    public Agente atualizarAgente(Long id, AgenteDTO agenteCadDTO){
        AtualizarAgenteUseCase atualizarAgenteUseCase = new AtualizarAgenteUseCase(agenteRepository);

        return atualizarAgenteUseCase.executarAtualizacaoAgente(id,agenteCadDTO);
    }

    @Transactional
    public void deletarAgente(Long id) {
        DeletarAgenteUseCase deletarAgenteUseCase = new DeletarAgenteUseCase(agenteRepository);

        deletarAgenteUseCase.executarDelecaoAgente(id);
    }

    public List<AgenteListagemDTO> listarAgentes() {
        ListarAgenteUseCase listarAgenteUseCase = new ListarAgenteUseCase(agenteRepository);

        return listarAgenteUseCase.executarListagem();

    }

}
