package com.ufrn.FarmaciaMedicamentos.controller;

import com.ufrn.FarmaciaMedicamentos.Service.MedicamentoService;
import com.ufrn.FarmaciaMedicamentos.domain.Medicamento;
import com.ufrn.FarmaciaMedicamentos.dto.MedicamentoRequestDto;
import com.ufrn.FarmaciaMedicamentos.dto.MedicamentoResponseDto;
import com.ufrn.FarmaciaMedicamentos.mapper.MedicamentoMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;
    private final MedicamentoMapper medicamentoMapper;

    public MedicamentoController(MedicamentoService medicamentoService, MedicamentoMapper medicamentoMapper) {
        this.medicamentoService = medicamentoService;
        this.medicamentoMapper = medicamentoMapper;
    }

    // GET - Listar todos
    @GetMapping
    public ResponseEntity<List<MedicamentoResponseDto>> listarTodos() {
        List<Medicamento> medicamentos = medicamentoService.listarTodos();
        List<MedicamentoResponseDto> dtos = medicamentos.stream()
                .map(medicamentoMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    // GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoResponseDto> buscarPorId(@PathVariable Long id) {
        Medicamento medicamento = medicamentoService.buscarPorId(id);
        MedicamentoResponseDto dto = medicamentoMapper.toDto(medicamento);
        return ResponseEntity.ok(dto);
    }

    // POST - Criar novo
    @PostMapping
    public ResponseEntity<MedicamentoResponseDto> salvar(@Valid @RequestBody MedicamentoRequestDto dto) {
        Medicamento medicamento = medicamentoMapper.toEntity(dto);
        Medicamento salvo = medicamentoService.salvar(medicamento);
        MedicamentoResponseDto responseDto = medicamentoMapper.toDto(salvo);
        return ResponseEntity.status(201).body(responseDto);
    }

    // PUT - Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoResponseDto> atualizar(@PathVariable Long id,
                                                            @Valid @RequestBody MedicamentoRequestDto dto) {
        Medicamento atualizado = medicamentoService.atualizar(id, dto);
        return ResponseEntity.ok(medicamentoMapper.toDto(atualizado));
    }

    // DELETE - Remover
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        medicamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
