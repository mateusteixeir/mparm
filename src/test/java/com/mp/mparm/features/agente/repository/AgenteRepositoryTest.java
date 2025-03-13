package com.mp.mparm.features.agente.repository;

import com.mp.mparm.features.agente.converter.AgenteConverter;
import com.mp.mparm.features.agente.model.dto.AgenteCadDTO;
import com.mp.mparm.features.agente.model.entity.Agente;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class AgenteRepositoryTest {

    @Autowired
    private AgenteRepository agenteRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void existsByCpf() {
        AgenteCadDTO agenteCadDTO = new AgenteCadDTO("Lucas", "Pereira", "12345678904", LocalDate.parse("1988-07-15"), "lucas.pereira@example.com", "11987654324");
        this.createAgente(agenteCadDTO);

        assertTrue(agenteRepository.existsByCpf("12345678904"));
    }

    @Test
    void existsByEmail() {
        AgenteCadDTO agenteCadDTO = new AgenteCadDTO("Lucas", "Pereira", "12345678904", LocalDate.parse("1988-07-15"), "lucas.pereira@example.com", "11987654324");
        this.createAgente(agenteCadDTO);

        assertTrue(agenteRepository.existsByEmail("lucas.pereira@example.com"));
    }

    @Test
    void findByDeletedAtIsNull() {
        AgenteCadDTO agenteCadDTO = new AgenteCadDTO("Lucas", "Pereira", "12345678904", LocalDate.parse("1988-07-15"), "lucas.pereira@example.com", "11987654324");
        this.createAgente(agenteCadDTO);

        assertNotNull(agenteRepository.findByDeletedAtIsNull());
    }

    @Test
    void findByIdAndDeletedAtIsNull() {
        AgenteCadDTO agenteCadDTO = new AgenteCadDTO("Lucas", "Pereira", "12345678904", LocalDate.parse("1988-07-15"), "lucas.pereira@example.com", "11987654324");
        Agente agente = this.createAgente(agenteCadDTO);
        assertTrue(agenteRepository.findByIdAndDeletedAtIsNull(agente.getId()).isPresent());
    }


    private Agente createAgente(AgenteCadDTO agenteCadDTO){
        Agente agente = AgenteConverter.fromAgente(agenteCadDTO);
        agenteRepository.save(agente);
        return agente;
    }

}
