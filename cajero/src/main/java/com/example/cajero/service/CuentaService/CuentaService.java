package com.example.cajero.service.CuentaService;

import com.example.cajero.domain.dto.CuentaDto.CuentaRequestDto;
import com.example.cajero.domain.dto.CuentaDto.CuentaResponseDto;
import com.example.cajero.domain.model.Cuenta;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface CuentaService {
    Flux<CuentaResponseDto> findAll();

    Mono<CuentaResponseDto> create(CuentaRequestDto cuentaRequestDto);

    Mono<CuentaResponseDto> update(Long id, CuentaRequestDto cuentaRequestDto);
    Mono<Cuenta> existAccount(Long id, CuentaRequestDto cuentaRequestDto);

    Mono<Void> delete(Long id);
}