package com.mp.mparm.features.reserva.service;

import com.mp.mparm.features.reserva.model.dto.ReservaDTO;
import com.mp.mparm.features.reserva.model.entity.Reserva;
import com.mp.mparm.features.reserva.repository.ReservaRepository;
import com.mp.mparm.features.agente.repository.AgenteRepository;
import com.mp.mparm.features.arma.repository.ArmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final AgenteRepository agenteRepository;
    private final ArmaRepository armaRepository;

    public List<Reserva> listar() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> buscarPorId(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva salvar(ReservaDTO dto) {
        var agente = agenteRepository.findById(dto.agenteId())
                .orElseThrow(() -> new IllegalArgumentException("Agente não encontrado"));

        var arma = armaRepository.findById(dto.armaId())
                .orElseThrow(() -> new IllegalArgumentException("Arma não encontrada"));

        Reserva reserva = new Reserva(null, agente, arma, dto.dataReserva(), dto.dataDevolucao(), "RESERVADA", null, null);
        return reservaRepository.save(reserva);
    }

    public void deletar(Long id) {
        reservaRepository.deleteById(id);
    }
}
