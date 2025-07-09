package com.ufrn.FarmaciaMedicamentos.Repository;

import com.ufrn.FarmaciaMedicamentos.domain.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}
