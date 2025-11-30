package main.java.service;

import main.java.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UsuarioService {

    private final List<Usuario> usuarios = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }

    public Optional<Usuario> findById(int id) {
        return usuarios.stream().filter(u -> u.getId() != null && u.getId().equals(id)).findFirst();
    }

    public Usuario create(Usuario usuario) {
        if (usuario.getId() == null || usuario.getId() == 0) {
            usuario.setId(idGenerator.getAndIncrement());
        }
        usuarios.add(usuario);
        return usuario;
    }

    public boolean delete(int id) {
        return usuarios.removeIf(u -> u.getId() != null && u.getId().equals(id));
    }
}
