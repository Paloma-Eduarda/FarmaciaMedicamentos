package com.ufrn.FarmaciaMedicamentos.controller;

import com.ufrn.FarmaciaMedicamentos.Service.MedicamentoService;
import com.ufrn.FarmaciaMedicamentos.mapper.MedicamentoMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {
    final MedicamentoService medicamentoService;
    final MedicamentoMapper medicamentoMapper;

    public MedicamentoController(MedicamentoMapper medicamentoMapper, MedicamentoService medicamentoService) {
        this.medicamentoMapper = medicamentoMapper;
        this.medicamentoService = medicamentoService;
    }
}
