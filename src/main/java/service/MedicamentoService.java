package main.java.service;

import main.java.model.Medicamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MedicamentoService {

    private final List<Medicamento> medicamentos = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public List<Medicamento> findAll() {
        return new ArrayList<>(medicamentos);
    }

    public Optional<Medicamento> findById(int id) {
        return medicamentos.stream().filter(m -> m.getId() != null && m.getId().equals(id)).findFirst();
    }

    public Medicamento create(Medicamento medicamento) {
        if (medicamento.getId() == null || medicamento.getId() == 0) {
            medicamento.setId(idGenerator.getAndIncrement());
        }
        medicamentos.add(medicamento);
        return medicamento;
    }

    public boolean delete(int id) {
        return medicamentos.removeIf(m -> m.getId() != null && m.getId().equals(id));
    }
}
