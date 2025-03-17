package com.mp.mparm.features.agente.service;

import com.mp.mparm.features.agente.converter.AgenteConverter;
import com.mp.mparm.features.agente.repository.IAgenteRepository;
import com.mp.mparm.features.agente.usecase.CriarAgenteUseCase;
import com.mp.mparm.features.exception.DuplicateResourceException;
import com.mp.mparm.features.agente.usecase.dto.AgenteCadDTO;
import com.mp.mparm.features.agente.usecase.dto.AgenteListagemDTO;
import com.mp.mparm.features.agente.model.entity.AgenteEntity;
import com.mp.mparm.features.agente.repository.IJPAAgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgenteService {

    @Autowired
    private IAgenteRepository agenteRepository;

    @Autowired
    private AgenteConverter agenteConverter;

    @Transactional
    public void cadastrarAgente(AgenteCadDTO agenteCadDTODTO) {
        CriarAgenteUseCase criacao = new CriarAgenteUseCase(agenteRepository);

        criacao.executarCriacao(agenteCadDTODTO);
    }

    @Transactional
    public AgenteEntity atualizarAgente(Long id, AgenteCadDTO agenteCadDTO){



        AgenteEntity agente = AgenteConverter.fromAgente(agenteCadDTO);

        AgenteEntity agenteAtualizado = agenteRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new IllegalArgumentException("Agente não encontrado"));

        if (agente.getNome() != null) {
            agenteAtualizado.setNome(agente.getNome());
        }
        if (agente.getSobrenome() != null) {
            agenteAtualizado.setSobrenome(agente.getSobrenome());
        }
        if (agente.getCpf() != null) {
            agenteAtualizado.setCpf(agente.getCpf());
        }
        if (agente.getDataNascimento() != null) {
            agenteAtualizado.setDataNascimento(agente.getDataNascimento());
        }
        if (agente.getEmail() != null) {
            agenteAtualizado.setEmail(agente.getEmail());
        }
        if (agente.getTelefone() != null) {
            agenteAtualizado.setTelefone(agente.getTelefone());
        }

        return agenteRepository.save(agenteAtualizado);
    }

    @Transactional
    public AgenteEntity deletarAgente(Long id) {
        AgenteEntity agente = agenteRepository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new RuntimeException("Agente não encontrado"));

        agente.setDeletedAt(LocalDateTime.now());
        return agenteRepository.save(agente);
    }

    public List<AgenteListagemDTO> listarAgentes() {
        return agenteRepository.findByDeletedAtIsNull().stream().map(AgenteListagemDTO::new).toList();
    }



}
