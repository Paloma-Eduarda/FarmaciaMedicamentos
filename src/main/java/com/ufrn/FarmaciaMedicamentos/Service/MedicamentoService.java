package com.ufrn.FarmaciaMedicamentos.Service;

import com.ufrn.FarmaciaMedicamentos.Repository.MedicamentoRepository;
import com.ufrn.FarmaciaMedicamentos.domain.Medicamento;
import com.ufrn.FarmaciaMedicamentos.dto.MedicamentoRequestDto;
import com.ufrn.FarmaciaMedicamentos.mapper.MedicamentoMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService extends AbstractService<Medicamento, MedicamentoRepository> {

    public  MedicamentoService(MedicamentoRepository medicamentoRepository) {
        super(medicamentoRepository);
    }

//    private final MedicamentoRepository repository;
//    private final MedicamentoMapper mapper;
//
//    public MedicamentoService(MedicamentoRepository repository, MedicamentoMapper mapper) {
//        this.repository = repository;
//        this.mapper = mapper;
//    }
//
//    // Lista todos os medicamentos
//    public List<Medicamento> listarTodos() {
//        return repository.findAll();
//    }
//
//    // Busca um medicamento pelo ID (lança exceção se não existir)
//    public Medicamento buscarPorId(Long id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Medicamento não encontrado. ID = " + id));
//    }
//
//    // Salva (ou atualiza) um medicamento já convertido em entidade
//    public Medicamento salvar(Medicamento medicamento) {
//        return repository.save(medicamento);
//    }
//
//    // Atualiza campos de um medicamento existente a partir de um DTO
//    public Medicamento atualizar(Long id, MedicamentoRequestDto dto) {
//        Medicamento existente = buscarPorId(id);
//
//        existente.setNomeComercial(dto.getNomeComercial());
//        existente.setLaboratorio(dto.getLaboratorio());
//        existente.setPreco(dto.getPreco());
//        existente.setPrincipioAtivo(dto.getPrincipioAtivo());
//        existente.setDosagem(dto.getDosagem());
//        existente.setNecessitaReceita(dto.isNecessitaReceita());
//
//        return repository.save(existente);
//    }
//
//    // Exclui um medicamento pelo ID
//    public void deletar(Long id) {
//        if (!repository.existsById(id)) {
//            throw new IllegalArgumentException("Medicamento não encontrado. ID = " + id);
//        }
//        repository.deleteById(id);
//    }
}
