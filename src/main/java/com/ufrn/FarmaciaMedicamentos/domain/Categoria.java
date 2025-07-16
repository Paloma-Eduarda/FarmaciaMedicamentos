package com.ufrn.FarmaciaMedicamentos.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idade;

    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Medicamento> medicamentos;
}
