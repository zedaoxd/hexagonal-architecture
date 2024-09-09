package br.com.bruno.hexagonalarchitecture.adapter.infra;

import br.com.bruno.hexagonalarchitecture.domain.dto.RequestPermitDTO;
import br.com.bruno.hexagonalarchitecture.domain.port.WebClientPort;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientImp implements WebClientPort {
    private final WebClient webClient;

    private WebClientImp() {
        this.webClient = WebClient.builder().build();
    }

    @Override
    public RequestPermitDTO get(String url) {
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(RequestPermitDTO.class)
                .block();
    }
}
