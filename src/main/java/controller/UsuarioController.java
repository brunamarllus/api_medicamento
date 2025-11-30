package main.java.controller;

import main.java.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.java.service.UsuarioService;

import java.util.List;

// Controller REST para gerenciar usuários
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Injeção do serviço via construtor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Lista todos os usuários
    @GetMapping
    public List<Usuario> list() {
        return usuarioService.findAll();
    }

    // Recupera um usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable int id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Cria um novo usuário
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario created = usuarioService.create(usuario);
        return ResponseEntity.ok(created);
    }

    // Remove um usuário por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean removed = usuarioService.delete(id);
        if (removed) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
