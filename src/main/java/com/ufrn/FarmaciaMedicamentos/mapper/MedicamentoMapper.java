package com.ufrn.FarmaciaMedicamentos.mapper;

import com.ufrn.FarmaciaMedicamentos.domain.Medicamento;
import com.ufrn.FarmaciaMedicamentos.dto.MedicamentoResponseDto;
import com.ufrn.FarmaciaMedicamentos.dto.MedicamentoResquestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicamentoMapper {
    Medicamento toEntity(MedicamentoResquestDto medicamentoResquestDto);
    MedicamentoResponseDto toDTO(Medicamento medicamento);
}
