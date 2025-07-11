package com.ufrn.FarmaciaMedicamentos.dto;


import com.ufrn.FarmaciaMedicamentos.controller.MedicamentoController;
import com.ufrn.FarmaciaMedicamentos.domain.Medicamento;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;


public class MedicamentoResponseDto extends RepresentationModel<MedicamentoResponseDto> {
    private String medicamento;

    public void loadLinks(Medicamento medicamento){
        this.add(WebMvcLinkBuilder.linkTo(MedicamentoController.class).slash(medicamento.getId()).withSelfRel());
        this.add(WebMvcLinkBuilder.linkTo(MedicamentoController.class).withRel("medicamentos"));
        this.add(WebMvcLinkBuilder.linkTo(MedicamentoController.class).slash(medicamento.getId()).withRel("delete"));
    }
}
