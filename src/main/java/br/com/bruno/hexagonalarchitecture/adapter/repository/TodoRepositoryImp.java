package br.com.bruno.hexagonalarchitecture.adapter.repository;

import br.com.bruno.hexagonalarchitecture.adapter.entity.TodoEntity;
import br.com.bruno.hexagonalarchitecture.domain.Todo;
import br.com.bruno.hexagonalarchitecture.domain.port.TodoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryImp implements TodoRepositoryPort {
    private final TodoRepository todoRepository;
    private final ModelMapper mapper;

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll().stream().map(entity -> mapper.map(entity, Todo.class)).toList();
    }

    @Override
    public Todo findById(Long id) {
        return todoRepository.findById(id).map(entity -> mapper.map(entity, Todo.class)).orElse(null);
    }

    @Override
    public Todo create(Todo todo) {
        TodoEntity entity = mapper.map(todo, TodoEntity.class);
        entity = todoRepository.save(entity);
        return mapper.map(entity, Todo.class);
    }

    @Override
    public Todo update(Todo todo, Long id) {
        TodoEntity entity = todoRepository.findById(id).orElse(null);
        if (entity == null) {
            return null;
        }
        entity = mapper.map(todo, TodoEntity.class);
        entity.setId(id);
        entity = todoRepository.save(entity);
        return mapper.map(entity, Todo.class);
    }

    @Override
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo markAsDone(Long id) {
        TodoEntity entity = todoRepository.findById(id).orElse(null);
        if (entity == null) {
            return null;
        }
        entity.setDone(true);
        entity = todoRepository.save(entity);
        return mapper.map(entity, Todo.class);
    }

    @Override
    public Todo markAsUndone(Long id) {
        TodoEntity entity = todoRepository.findById(id).orElse(null);
        if (entity == null) {
            return null;
        }
        entity.setDone(false);
        entity = todoRepository.save(entity);
        return mapper.map(entity, Todo.class);
    }
}
