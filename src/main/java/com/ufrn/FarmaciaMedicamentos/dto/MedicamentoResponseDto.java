package com.ufrn.FarmaciaMedicamentos.dto;


import com.ufrn.FarmaciaMedicamentos.controller.MedicamentoController;
import com.ufrn.FarmaciaMedicamentos.domain.Medicamento;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@Data
public class MedicamentoResponseDto extends RepresentationModel<MedicamentoResponseDto> {
    Long id;
    String nomeComercial;
    String laboratorio;
    Double preco;
    String principioAtivo;
    String dosagem;
    boolean necessitaReceita;

    public void loadLinks(Medicamento medicamento){
        this.add(WebMvcLinkBuilder.linkTo(MedicamentoController.class).slash(medicamento.getId()).withSelfRel());
        this.add(WebMvcLinkBuilder.linkTo(MedicamentoController.class).withRel("medicamentos"));
        this.add(WebMvcLinkBuilder.linkTo(MedicamentoController.class).slash(medicamento.getId()).withRel("delete"));
    }
}
