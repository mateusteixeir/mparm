package com.mp.mparm.features.arma.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ArmaDTO(
        Long id,

        @NotBlank
        String modelo,

        @NotNull
        Long calibreId,

        @NotNull
        Long fabricanteId,

        @NotBlank
        String numeroSerie
) {}
