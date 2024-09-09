package br.com.bruno.hexagonalarchitecture.domain.service;

import br.com.bruno.hexagonalarchitecture.domain.Todo;
import br.com.bruno.hexagonalarchitecture.domain.dto.TodoDTO;
import br.com.bruno.hexagonalarchitecture.domain.port.TodoRepositoryPort;
import br.com.bruno.hexagonalarchitecture.domain.port.TodoServicePort;
import br.com.bruno.hexagonalarchitecture.domain.port.WebClientPort;

import java.util.List;

public class TodoService implements TodoServicePort {
    private final TodoRepositoryPort todoRepositoryPort;
    private final WebClientPort webClientPort;

    public TodoService(
            TodoRepositoryPort todoRepositoryPort,
            WebClientPort webClientPort
    ) {
        this.todoRepositoryPort = todoRepositoryPort;
        this.webClientPort = webClientPort;
    }

    @Override
    public List<TodoDTO> findAll() {
        var entities = todoRepositoryPort.findAll();
        return entities.stream().map(TodoDTO::new).toList();
    }

    @Override
    public TodoDTO findById(Long id) {
        return new TodoDTO(todoRepositoryPort.findById(id));
    }

    @Override
    public TodoDTO create(TodoDTO todo) {
        var entity = Todo.builder()
                .description(todo.description())
                .done(todo.done())
                .build();
        return new TodoDTO(todoRepositoryPort.create(entity));
    }

    @Override
    public TodoDTO update(TodoDTO todo, Long id) {
        var response = webClientPort.get("https://my-json-server.typicode.com/zedaoxd/hexagonal-architecture/mock-request");
        if (!response.permit()) {
            throw new RuntimeException("Not allowed");
        }

        var entity = Todo.builder()
                .description(todo.description())
                .done(todo.done())
                .build();
        return new TodoDTO(todoRepositoryPort.update(entity, id));
    }

    @Override
    public void delete(Long id) {
        todoRepositoryPort.delete(id);
    }

    @Override
    public TodoDTO markAsDone(Long id) {
        return new TodoDTO(todoRepositoryPort.markAsDone(id));
    }

    @Override
    public TodoDTO markAsUndone(Long id) {
        return new TodoDTO(todoRepositoryPort.markAsUndone(id));
    }
}
