
package com.ufrn.FarmaciaMedicamentos.Repository;

import com.ufrn.FarmaciaMedicamentos.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
