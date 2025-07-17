package com.ufrn.FarmaciaMedicamentos.Service;

import com.ufrn.FarmaciaMedicamentos.Repository.MedicamentoRepository;
import com.ufrn.FarmaciaMedicamentos.domain.Medicamento;

import org.springframework.stereotype.Service;


@Service
public class MedicamentoService extends GenericCrudService<Medicamento, Long, MedicamentoRepository> {

    public  MedicamentoService(MedicamentoRepository medicamentoRepository) {
        super(medicamentoRepository);
    }

}

