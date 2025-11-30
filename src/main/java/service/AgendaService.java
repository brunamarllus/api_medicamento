package main.java.service;

import main.java.model.AgendaMedicamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AgendaService implements CrudService<AgendaMedicamento> {

    private final List<AgendaMedicamento> agendas = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    @Override
    public List<AgendaMedicamento> findAll() {
        return new ArrayList<>(agendas);
    }

    @Override
    public Optional<AgendaMedicamento> findById(int id) {
        return agendas.stream()
                .filter(a -> a.getId() != null && a.getId().equals(id))
                .findFirst();
    }

    @Override
    public AgendaMedicamento create(AgendaMedicamento agenda) {
        if (agenda.getId() == null || agenda.getId() == 0) {
            agenda.setId(idGenerator.getAndIncrement());
        }
        agendas.add(agenda);
        return agenda;
    }

    @Override
    public boolean delete(int id) {
        return agendas.removeIf(a -> a.getId() != null && a.getId().equals(id));
    }
}
