package com.ufrn.FarmaciaMedicamentos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoRequestDto {
    String nomeComercial;
    String laboratorio;
    Double preco;
    String principioAtivo;
    String dosagem;
    boolean necessitaReceita;
}

