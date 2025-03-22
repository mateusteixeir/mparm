package com.mp.mparm.features.agente.repository;

import com.mp.mparm.features.agente.converter.AgenteConverter;
import com.mp.mparm.features.agente.model.dto.AgenteDTO;
import com.mp.mparm.features.agente.model.entity.Agente;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ActiveProfiles("test")
class AgenteRepositoryTest {

    @Autowired
    private AgenteRepository agenteRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Valida se existe um agente no banco de dados com base no CPF Informado.")
    void existsByCpfCase1() {
        AgenteDTO agenteCadDTO = new AgenteDTO("Lucas", "Pereira", "12345678904", LocalDate.parse("1988-07-15"), "lucas.pereira@example.com", "11987654324");
        this.createAgente(agenteCadDTO);

        assertTrue(agenteRepository.existsByCpf("12345678904"));
    }

    @Test
    @DisplayName("Valida se não existe um agente no banco de dados com base no CPF Informado.")
    void existsByCpfCase2() {

        assertFalse(agenteRepository.existsByCpf("12345678904"));
    }

    @Test
    @DisplayName("Valida se existe um agente no banco de dados com base no EMAIL Informado.")
    void existsByEmailCase1() {
        AgenteDTO agenteCadDTO = new AgenteDTO("Lucas", "Pereira", "12345678904", LocalDate.parse("1988-07-15"), "lucas.pereira@example.com", "11987654324");
        this.createAgente(agenteCadDTO);

        assertTrue(agenteRepository.existsByEmail("lucas.pereira@example.com"));
    }

    @Test
    @DisplayName("Valida se não existe um agente no banco de dados com base no EMAIL Informado.")
    void existsByEmailCase2() {

        assertFalse(agenteRepository.existsByEmail("lucas.pereira@example.com"));
    }

    @Test
    @DisplayName("Deve validar se retorna uma lista com um elemento")
    void findByDeletedAtIsNullCase1() {
        AgenteDTO agenteCadDTO = new AgenteDTO("Lucas", "Pereira", "12345678904", LocalDate.parse("1988-07-15"), "lucas.pereira@example.com", "11987654324");
        this.createAgente(agenteCadDTO);

        List<Agente> agentesAtivos = agenteRepository.findByDeletedAtIsNull();

        assertThat(agentesAtivos).hasSize(1);
    }

    @Test
    @DisplayName("Deve validar se retorna uma lista vazia")
    void findByDeletedAtIsNullCase2() {

        List<Agente> agentesAtivos = agenteRepository.findByDeletedAtIsNull();

        assertThat(agentesAtivos).isEmpty();
    }

    @Test
    @DisplayName("Valida se retorna algum agente.")
    void findByIdAndDeletedAtIsNullCase1() {
        AgenteDTO agenteCadDTO = new AgenteDTO("Lucas", "Pereira", "12345678904", LocalDate.parse("1988-07-15"), "lucas.pereira@example.com", "11987654324");
        Agente agente = this.createAgente(agenteCadDTO);
        Optional<Agente> result = agenteRepository.findByIdAndDeletedAtIsNull(agente.getId());

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Valida de não retorna nenhum agente do banco de dados.")
    void findByIdAndDeletedAtIsNullCase2() {

        Optional<Agente> result = agenteRepository.findByIdAndDeletedAtIsNull(1L);

        assertThat(result.isPresent()).isFalse();
    }


    private Agente createAgente(AgenteDTO agenteCadDTO){
        Agente agente = AgenteConverter.fromAgente(agenteCadDTO);
        agenteRepository.save(agente);
        return agente;
    }

}
