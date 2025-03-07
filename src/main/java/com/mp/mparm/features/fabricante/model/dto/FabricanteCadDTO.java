package com.mp.mparm.features.fabricante.model.dto;

import jakarta.validation.constraints.NotBlank;

public record FabricanteCadDTO(

        @NotBlank(message = "Nome do Fabricante é obrigatório") String nome,
        @NotBlank(message = "CNPJ do Fabricante é obrigatório") String cnpj
) { }

