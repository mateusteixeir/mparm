package com.mp.mparm.features.calibre.model.dto;

import jakarta.validation.constraints.NotBlank;

public record CalibreDTO(
        @NotBlank(message = "A descrição é obrigatória")
        String descricao
) { }
