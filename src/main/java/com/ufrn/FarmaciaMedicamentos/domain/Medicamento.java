package com.ufrn.FarmaciaMedicamentos.domain;

import jakarta.persistence.Entity;
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
@SQLDelete(sql = "UPDATE medicamente SET deleted_at = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("deleted_at is null")
public class Medicamento extends BaseEntity {

    @NotBlank
    String nomeComercial;
    String laboratorio;
    Double preco;
    String principioAtivo;
    String dosagem;
    boolean necessitaReceita;

}
