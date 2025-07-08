package com.ufrn.FarmaciaMedicamentos.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SQLDelete(sql = "UPDATE medicamente SET deleted_at = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("deleted_at is null")
public class medicamento extends baseEntity{

    private String nomeComercial;
    private String laboratorio;
    private Double preco;
    private String principioAtivo;
    private String dosagem;
    private boolean necessitaReceita;

}
