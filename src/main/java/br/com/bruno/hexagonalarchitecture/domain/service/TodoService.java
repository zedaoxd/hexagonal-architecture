package br.com.bruno.hexagonalarchitecture.domain.service;

import br.com.bruno.hexagonalarchitecture.domain.Todo;
import br.com.bruno.hexagonalarchitecture.domain.port.TodoRepositoryPort;
import br.com.bruno.hexagonalarchitecture.domain.port.TodoServicePort;

import java.util.List;

public class TodoService implements TodoServicePort {
    private final TodoRepositoryPort todoRepositoryPort;

    public TodoService(TodoRepositoryPort todoRepositoryPort) {
        this.todoRepositoryPort = todoRepositoryPort;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepositoryPort.findAll();
    }

    @Override
    public Todo findById(Long id) {
        return todoRepositoryPort.findById(id);
    }

    @Override
    public Todo create(Todo todo) {
        return todoRepositoryPort.create(todo);
    }

    @Override
    public Todo update(Todo todo, Long id) {
        return todoRepositoryPort.update(todo, id);
    }

    @Override
    public void delete(Long id) {
        todoRepositoryPort.delete(id);
    }

    @Override
    public Todo markAsDone(Long id) {
        return todoRepositoryPort.markAsDone(id);
    }

    @Override
    public Todo markAsUndone(Long id) {
        return todoRepositoryPort.markAsUndone(id);
    }
}
