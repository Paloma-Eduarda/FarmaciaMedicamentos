package com.ufrn.FarmaciaMedicamentos.mapper;

import com.ufrn.FarmaciaMedicamentos.domain.Medicamento;
import com.ufrn.FarmaciaMedicamentos.dto.MedicamentoResponseDto;
import com.ufrn.FarmaciaMedicamentos.dto.MedicamentoRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MedicamentoMapper {
    Medicamento toEntity(MedicamentoRequestDto medicamentoResquestDto);
    MedicamentoResponseDto toDto(Medicamento medicamento);
    Medicamento updateEntityFromDto(MedicamentoRequestDto dto, @MappingTarget Medicamento entity);
}
