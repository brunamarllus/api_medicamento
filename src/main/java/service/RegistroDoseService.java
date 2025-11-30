package main.java.service;

import main.java.model.RegistroDose;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RegistroDoseService {

    private final List<RegistroDose> registros = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public List<RegistroDose> findAll() {
        return new ArrayList<>(registros);
    }

    public Optional<RegistroDose> findById(int id) {
        return registros.stream().filter(r -> r.getId() != null && r.getId().equals(id)).findFirst();
    }

    public RegistroDose create(RegistroDose registro) {
        if (registro.getId() == null || registro.getId() == 0) {
            registro.setId(idGenerator.getAndIncrement());
        }
        registros.add(registro);
        return registro;
    }

    public boolean delete(int id) {
        return registros.removeIf(r -> r.getId() != null && r.getId().equals(id));
    }
}
