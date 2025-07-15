package com.ufrn.FarmaciaMedicamentos.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@SQLDelete(sql = "UPDATE medicamento SET data_exclusao = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("data_exclusao is null")
public class Medicamento extends BaseEntity {

    @NotBlank
    String nomeComercial;
    String laboratorio;
    Double preco;
    String principioAtivo;
    String dosagem;
    boolean necessitaReceita;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    Categoria categoria;
}
