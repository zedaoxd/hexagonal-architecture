package br.com.bruno.hexagonalarchitecture.domain.port;

import br.com.bruno.hexagonalarchitecture.domain.dto.TodoDTO;

import java.util.List;

public interface TodoServicePort {
    List<TodoDTO> findAll();
    TodoDTO findById(Long id);
    TodoDTO create(TodoDTO todo);
    TodoDTO update(TodoDTO todo, Long id);
    void delete(Long id);
    TodoDTO markAsDone(Long id);
    TodoDTO markAsUndone(Long id);
}
