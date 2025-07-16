package com.ufrn.FarmaciaMedicamentos.mapper;

import com.ufrn.FarmaciaMedicamentos.domain.Categoria;
import com.ufrn.FarmaciaMedicamentos.dto.CategoriaRequestDto;
import com.ufrn.FarmaciaMedicamentos.dto.CategoriaResponseDto;

public class CategoriaMapper {

    public static Categoria toEntity(CategoriaRequestDto dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        return categoria;
    }

    public static CategoriaResponseDto toResponse(Categoria categoria) {
        CategoriaResponseDto dto = new CategoriaResponseDto();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        return dto;
    }
}
