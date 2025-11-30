package main.java.service;

import main.java.model.Medicamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MedicamentoService implements CrudService<Medicamento> {

    private final List<Medicamento> medicamentos = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    @Override
    public List<Medicamento> findAll() {
        return new ArrayList<>(medicamentos);
    }

    @Override
    public Optional<Medicamento> findById(int id) {
        return medicamentos.stream().filter(m -> m.getId() != null && m.getId().equals(id)).findFirst();
    }

    @Override
    public Medicamento create(Medicamento medicamento) {
        if (medicamento.getId() == null || medicamento.getId() == 0) {
            medicamento.setId(idGenerator.getAndIncrement());
        }
        medicamentos.add(medicamento);
        return medicamento;
    }

    @Override
    public boolean delete(int id) {
        return medicamentos.removeIf(m -> m.getId() != null && m.getId().equals(id));
    }
}
