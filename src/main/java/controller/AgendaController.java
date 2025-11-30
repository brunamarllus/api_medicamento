package main.java.controller;

import main.java.model.AgendaMedicamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.java.service.AgendaService;

import java.util.List;

@RestController
@RequestMapping("/api/agendas")
public class AgendaController {

    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public List<AgendaMedicamento> list() {
        return agendaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaMedicamento> getById(@PathVariable int id) {
        return agendaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AgendaMedicamento> create(@RequestBody AgendaMedicamento agenda) {
        AgendaMedicamento created = agendaService.create(agenda);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean removed = agendaService.delete(id);
        if (removed) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
