package com.example.persona.service;

import com.example.persona.domain.dto.ClienteRequestDto;
import com.example.persona.domain.dto.ClienteResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ClientService {

    Flux<ClienteResponseDto> findAll();
    Flux<ClienteResponseDto> findAllClientAndPerson();
    Mono<ClienteResponseDto> create(ClienteRequestDto clienteRequestDto);
    Mono<ClienteResponseDto> update(Long id, ClienteRequestDto clienteRequestDto);
    Mono<Void> delete(Long id);
}
