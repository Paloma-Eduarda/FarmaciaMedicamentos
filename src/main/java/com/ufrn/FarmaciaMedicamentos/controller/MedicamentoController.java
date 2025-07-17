package com.ufrn.FarmaciaMedicamentos.controller;

import com.ufrn.FarmaciaMedicamentos.Service.MedicamentoService;
import com.ufrn.FarmaciaMedicamentos.domain.Medicamento;
import com.ufrn.FarmaciaMedicamentos.dto.MedicamentoRequestDto;
import com.ufrn.FarmaciaMedicamentos.dto.MedicamentoResponseDto;
import com.ufrn.FarmaciaMedicamentos.mapper.MedicamentoMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/medicamentos")
@RequiredArgsConstructor
public class MedicamentoController {

    private final MedicamentoService medicamentoService;
    private final MedicamentoMapper medicamentoMapper;

    // GET - Listar todos com paginação
    @GetMapping
    public ResponseEntity<Page<MedicamentoResponseDto>> listAll(Pageable pageable) {
        Page<Medicamento> medicamentosPage = medicamentoService.listAll(pageable);
        Page<MedicamentoResponseDto> dtoPage = medicamentosPage.map(medicamentoMapper::toDto);
        return ResponseEntity.ok(dtoPage);
    }

    // GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoResponseDto> buscarPorId(@PathVariable Long id) {
        try {
            Medicamento medicamento = medicamentoService.listById(id);
            MedicamentoResponseDto dto = medicamentoMapper.toDto(medicamento);
            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // POST - Criar novo
    @PostMapping
    public ResponseEntity<MedicamentoResponseDto> salvar(@RequestBody MedicamentoRequestDto dto) {
        Medicamento entity = medicamentoMapper.toEntity(dto);
        Medicamento salvo = medicamentoService.create(entity);
        MedicamentoResponseDto responseDto = medicamentoMapper.toDto(salvo);
        return ResponseEntity.created(URI.create("/medicamentos/" + salvo.getId()))
                .body(responseDto);
    }

    // PUT - Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody MedicamentoRequestDto dto) {
        try {
            Medicamento medicamento = medicamentoService.listById(id); // verifica se existe
            medicamento.setNomeComercial(dto.getNomeComercial());
            medicamento.setLaboratorio(dto.getLaboratorio());
            medicamento.setPreco(dto.getPreco());
            medicamento.setPrincipioAtivo(dto.getPrincipioAtivo());
            medicamento.setDosagem(dto.getDosagem());
            medicamento.setNecessitaReceita(dto.isNecessitaReceita());

            Medicamento atualizado = medicamentoService.update(medicamento, id);
            return ResponseEntity.ok(atualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicamento não encontrado.");
        }
    }

    // DELETE - Remover
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            medicamentoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

