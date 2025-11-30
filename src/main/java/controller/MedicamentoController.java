package main.java.controller;

import main.java.model.Medicamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.java.service.MedicamentoService;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @GetMapping
    public List<Medicamento> list() {
        return medicamentoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getById(@PathVariable int id) {
        return medicamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Medicamento> create(@RequestBody Medicamento medicamento) {
        Medicamento created = medicamentoService.create(medicamento);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean removed = medicamentoService.delete(id);
        if (removed) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
