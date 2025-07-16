package com.ufrn.FarmaciaMedicamentos.mapper;

import com.ufrn.FarmaciaMedicamentos.domain.Pessoa;
import com.ufrn.FarmaciaMedicamentos.dto.PessoaRequestDto;
import com.ufrn.FarmaciaMedicamentos.dto.PessoaResponseDto;

public class PessoaMapper {

    public static Pessoa toEntity(PessoaRequestDto dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        return pessoa;
    }

    public static PessoaResponseDto toResponse(Pessoa pessoa) {
        PessoaResponseDto dto = new PessoaResponseDto();
        dto.setId(pessoa.getId());
        return dto;
    }
}
