package main.java.controller;

import main.java.model.RegistroDose;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.java.service.RegistroDoseService;

import java.util.List;

@RestController
@RequestMapping("/api/registros")
public class RegistroDoseController {

    private final RegistroDoseService registroDoseService;

    public RegistroDoseController(RegistroDoseService registroDoseService) {
        this.registroDoseService = registroDoseService;
    }

    @GetMapping
    public List<RegistroDose> list() {
        return registroDoseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroDose> getById(@PathVariable int id) {
        return registroDoseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RegistroDose> create(@RequestBody RegistroDose registro) {
        RegistroDose created = registroDoseService.create(registro);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean removed = registroDoseService.delete(id);
        if (removed) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
