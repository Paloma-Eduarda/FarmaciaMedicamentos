package com.ufrn.FarmaciaMedicamentos.Service;

import com.ufrn.FarmaciaMedicamentos.Repository.CategoriaRepository;
import com.ufrn.FarmaciaMedicamentos.Repository.MedicamentoRepository;
import com.ufrn.FarmaciaMedicamentos.domain.Categoria;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends GenericCrudService<Categoria, Long, CategoriaRepository>{
    public  CategoriaService(CategoriaRepository categoriaRepository) {
        super(categoriaRepository);
    }
}
