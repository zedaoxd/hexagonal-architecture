package br.com.bruno.hexagonalarchitecture.adapter.infra;

import br.com.bruno.hexagonalarchitecture.domain.port.TodoRepositoryPort;
import br.com.bruno.hexagonalarchitecture.domain.port.TodoServicePort;
import br.com.bruno.hexagonalarchitecture.domain.port.WebClientPort;
import br.com.bruno.hexagonalarchitecture.domain.service.TodoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoServicePortConfig {

    @Bean
    public TodoServicePort todoServicePort(
            TodoRepositoryPort todoRepositoryPort,
            WebClientPort webClientPort
    ) {
        return new TodoService(todoRepositoryPort, webClientPort);
    }
}
