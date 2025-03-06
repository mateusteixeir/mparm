package com.mp.mparm.features.agente.service;

import com.mp.mparm.features.agente.converter.AgenteConverter;
import com.mp.mparm.features.exception.DuplicateResourceException;
import com.mp.mparm.features.agente.model.dto.AgenteCadDTO;
import com.mp.mparm.features.agente.model.dto.AgenteListagemDTO;
import com.mp.mparm.features.agente.model.entity.Agente;
import com.mp.mparm.features.agente.repository.AgenteRepository;
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
        if (agenteRepository.existsByCpf(agente.getCpf())) {
            throw new DuplicateResourceException("CPF já cadastrado.");
        }
        if (agenteRepository.existsByEmail(agente.getEmail())) {
            throw new DuplicateResourceException("Email já cadastrado.");
        }

        return agenteRepository.save(agente);
    }

    @Transactional
    public Agente atualizarAgente(Long id, AgenteCadDTO agenteCadDTO){

        if (agenteRepository.existsByCpf(agenteCadDTO.cpf())) {
            throw new DuplicateResourceException("Já existe um agente com este CPF.");
        }

        if (agenteRepository.existsByEmail(agenteCadDTO.email())) {
            throw new DuplicateResourceException("Já existe um agente com este email.");
        }

        Agente agente = AgenteConverter.fromAgente(agenteCadDTO);

        Agente agenteAtualizado = agenteRepository.findByIdAndDeletedAtIsNull(id)
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
    public Agente deletarAgente(Long id) {
        Agente agente = agenteRepository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new RuntimeException("Agente não encontrado"));

        agente.setDeletedAt(LocalDateTime.now());
        return agenteRepository.save(agente);
    }

    public List<AgenteListagemDTO> listarAgentes() {
        return agenteRepository.findByDeletedAtIsNull().stream().map(AgenteListagemDTO::new).toList();
    }



}
