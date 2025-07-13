package com.ufrn.FarmaciaMedicamentos.domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE pessoa SET data_exclusao = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("data_exclusao is null")
public class Pessoa extends BaseEntity {
    @NotBlank
    String nome;
    int idade;
    boolean isAdmin = false;

}

