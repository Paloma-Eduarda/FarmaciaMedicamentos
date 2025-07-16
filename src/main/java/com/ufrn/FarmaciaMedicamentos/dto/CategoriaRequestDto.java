package com.ufrn.FarmaciaMedicamentos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoriaRequestDto {
    @NotBlank
    private String nome;
}
