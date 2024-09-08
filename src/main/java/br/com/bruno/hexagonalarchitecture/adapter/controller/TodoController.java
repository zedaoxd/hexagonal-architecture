package br.com.bruno.hexagonalarchitecture.adapter.controller;

import br.com.bruno.hexagonalarchitecture.domain.dto.TodoDTO;
import br.com.bruno.hexagonalarchitecture.domain.port.TodoServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoServicePort todoServicePort;

    @GetMapping
    public ResponseEntity<List<TodoDTO>> findAll() {
        return ResponseEntity.ok(todoServicePort.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(todoServicePort.findById(id));
    }

    @PostMapping
    public ResponseEntity<TodoDTO> create(@RequestBody TodoDTO todo) {
        return ResponseEntity.ok(todoServicePort.create(todo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO> update(@RequestBody TodoDTO todo, @PathVariable Long id) {
        return ResponseEntity.ok(todoServicePort.update(todo, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        todoServicePort.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/done")
    public ResponseEntity<TodoDTO> markAsDone(@PathVariable Long id) {
        return ResponseEntity.ok(todoServicePort.markAsDone(id));
    }

    @PutMapping("/{id}/undone")
    public ResponseEntity<TodoDTO> markAsUndone(@PathVariable Long id) {
        return ResponseEntity.ok(todoServicePort.markAsUndone(id));
    }
}
