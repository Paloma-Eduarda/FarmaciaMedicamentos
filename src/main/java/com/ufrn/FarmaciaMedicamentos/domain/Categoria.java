package com.ufrn.FarmaciaMedicamentos.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@SQLDelete(sql = "UPDATE medicamento SET data_exclusao = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("data_exclusao is null")
public class Categoria extends BaseEntity {

    String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Medicamento> medicamentos;
}
