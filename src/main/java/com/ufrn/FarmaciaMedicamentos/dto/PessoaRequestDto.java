package com.ufrn.FarmaciaMedicamentos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PessoaRequestDto {
    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;
}
