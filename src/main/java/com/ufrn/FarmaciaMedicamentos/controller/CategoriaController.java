package com.ufrn.FarmaciaMedicamentos.controller;

import com.ufrn.FarmaciaMedicamentos.Service.CategoriaService;
import com.ufrn.FarmaciaMedicamentos.domain.Categoria;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor

public class CategoriaController {
   CategoriaService service;
    @GetMapping
    public Page<Categoria> listaCategorias(Pageable pageable){
        return service.listAll(pageable);
    }
}