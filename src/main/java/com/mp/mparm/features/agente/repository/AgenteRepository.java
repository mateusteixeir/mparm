package com.mp.mparm.features.agente.repository;

import com.mp.mparm.features.agente.converter.AgenteConverter;
import com.mp.mparm.features.agente.model.domain.Agente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AgenteRepository implements IAgenteRepository{

    @Autowired
    private IJPAAgenteRepository repository;

    AgenteConverter agenteConverter = new AgenteConverter();


    @Override
    public void save(Agente agente) {
        repository.save(agenteConverter.domainToEntity(agente));
    }

    @Override
    public boolean existsByCpf(String cpf) {

        return repository.existsByCpf(cpf);
    }

    @Override
    public boolean existsByEmail(String email) {

        return repository.existsByEmail(email);
    }

    @Override
    public List<Agente> findByDeletedAtIsNull() {


        return repository.findByDeletedAtIsNull().stream().map(agenteConverter::entityToDomain).toList();
    }

    @Override
    public Optional<Agente> findByIdAndDeletedAtIsNull(Long id) {
        return Optional.empty();
    }
}
