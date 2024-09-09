package br.com.bruno.hexagonalarchitecture.domain.port;

import br.com.bruno.hexagonalarchitecture.domain.dto.RequestPermitDTO;

public interface WebClientPort {
    RequestPermitDTO get(String url);
}
