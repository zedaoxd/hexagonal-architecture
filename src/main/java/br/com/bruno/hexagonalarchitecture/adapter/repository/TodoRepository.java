package br.com.bruno.hexagonalarchitecture.adapter.repository;

import br.com.bruno.hexagonalarchitecture.adapter.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
