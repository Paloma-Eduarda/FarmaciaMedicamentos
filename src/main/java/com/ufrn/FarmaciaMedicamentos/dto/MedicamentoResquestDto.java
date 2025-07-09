package com.ufrn.FarmaciaMedicamentos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicamentoResquestDto {
    String nomeComercial;
    String laboratorio;
    Double preco;
    String principioAtivo;
    String dosagem;
    boolean necessitaReceita;
}
