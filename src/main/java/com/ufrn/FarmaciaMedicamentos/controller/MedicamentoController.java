package com.ufrn.FarmaciaMedicamentos.controller;

import com.ufrn.FarmaciaMedicamentos.Service.MedicamentoService;
import com.ufrn.FarmaciaMedicamentos.domain.Medicamento;
import com.ufrn.FarmaciaMedicamentos.dto.MedicamentoRequestDto;
import com.ufrn.FarmaciaMedicamentos.dto.MedicamentoResponseDto;
import com.ufrn.FarmaciaMedicamentos.mapper.MedicamentoMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    final MedicamentoService medicamentoService;
    final MedicamentoMapper medicamentoMapper;

    public MedicamentoController(MedicamentoService medicamentoService, MedicamentoMapper medicamentoMapper) {
        this.medicamentoService = medicamentoService;
        this.medicamentoMapper = medicamentoMapper;
    }

    // GET - Listar todos
    @GetMapping
    public List<MedicamentoResponseDto> listarTodos() {
        List<Medicamento> medicamentos = medicamentoService.listar();
        List<MedicamentoResponseDto> dtos = new ArrayList<>();

        for(Medicamento medicamento : medicamentos) {
                MedicamentoResponseDto dtoLocal = medicamentoMapper.toDto(medicamento);
                dtoLocal.loadLinks(medicamento);
                dtos.add(dtoLocal);
        }

        return dtos;
    }

    // GET - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoResponseDto> buscarPorId(@PathVariable Long id) {
        Optional<Medicamento> medicamento = medicamentoService.buscarPorId(id);
        if(medicamento.isPresent()) {
            MedicamentoResponseDto dto = medicamentoMapper.toDto(medicamento.get());
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    // POST - Criar novo
    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody MedicamentoRequestDto dto)throws URISyntaxException {
        Medicamento medicamento = medicamentoMapper.toEntity(dto);
        Medicamento salvo = medicamentoService.adicionar(medicamento);
        MedicamentoResponseDto responseDto = medicamentoMapper.toDto(salvo);
        return ResponseEntity.created(new URI("/medicamentos"+medicamento.getId())).build();
    }

    // PUT - Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Medicamento m) {

        Optional<Medicamento> medicamento = medicamentoService.buscarPorId(id);
        if(medicamento.isPresent()) {
            return ResponseEntity.ok(medicamentoService.alterar(m));
        }

        return ResponseEntity.notFound().build();
    }

//    // DELETE - Remover
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable Long id)  {
//        medicamentoService.deletar(id);
//        return ResponseEntity.noContent().build();
//    }
}
