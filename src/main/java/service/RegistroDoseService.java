package main.java.service;

import main.java.model.RegistroDose;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RegistroDoseService implements CrudService<RegistroDose> {

    private final List<RegistroDose> registros = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    @Override
    public List<RegistroDose> findAll() {
        return new ArrayList<>(registros);
    }

    @Override
    public Optional<RegistroDose> findById(int id) {
        return registros.stream().filter(r -> r.getId() != null && r.getId().equals(id)).findFirst();
    }

    @Override
    public RegistroDose create(RegistroDose registro) {
        if (registro.getId() == null || registro.getId() == 0) {
            registro.setId(idGenerator.getAndIncrement());
        }
        registros.add(registro);
        return registro;
    }

    @Override
    public boolean delete(int id) {
        return registros.removeIf(r -> r.getId() != null && r.getId().equals(id));
    }
}
