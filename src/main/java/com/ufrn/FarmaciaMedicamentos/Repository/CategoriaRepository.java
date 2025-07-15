
package com.ufrn.FarmaciaMedicamentos.Repository;

import com.ufrn.FarmaciaMedicamentos.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
