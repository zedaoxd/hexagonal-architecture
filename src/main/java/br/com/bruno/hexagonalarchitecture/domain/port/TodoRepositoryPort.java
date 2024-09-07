package br.com.bruno.hexagonalarchitecture.domain.port;

import br.com.bruno.hexagonalarchitecture.domain.Todo;

import java.util.List;

public interface TodoRepositoryPort {
    List<Todo> findAll();
    Todo findById(Long id);
    Todo create(Todo todo);
    Todo update(Todo todo, Long id);
    void delete(Long id);
    Todo markAsDone(Long id);
    Todo markAsUndone(Long id);
}
