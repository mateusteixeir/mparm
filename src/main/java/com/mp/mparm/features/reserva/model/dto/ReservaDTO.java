package com.mp.mparm.features.reserva.model.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record ReservaDTO(
        Long id,

        @NotNull
        Long agenteId,

        @NotNull
        Long armaId,

        @NotNull
        LocalDate dataReserva,

        LocalDate dataDevolucao
) {}
