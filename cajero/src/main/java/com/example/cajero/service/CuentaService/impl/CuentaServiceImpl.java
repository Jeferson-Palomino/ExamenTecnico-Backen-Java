package com.example.cajero.service.CuentaService.impl;

import com.example.cajero.domain.dto.CuentaDto.CuentaRequestDto;
import com.example.cajero.domain.dto.CuentaDto.CuentaResponseDto;
import com.example.cajero.domain.mapper.CuentaMapper.CuentaMapper;
import com.example.cajero.domain.model.Cuenta;
import com.example.cajero.exception.ResourceNotFoundException;
import com.example.cajero.repository.CuentaRepository;
import com.example.cajero.service.CuentaService.CuentaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.cajero.domain.mapper.CuentaMapper.CuentaMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class CuentaServiceImpl implements CuentaService {
    private static final Logger logger = LoggerFactory.getLogger(CuentaServiceImpl.class);
    private final CuentaRepository cuentaRepository;
    @Override
    public Flux<CuentaResponseDto> findAll() {
        return this.cuentaRepository.findAll()
                .map(CuentaMapper::toDto);
    }

    @Override
    public Mono<CuentaResponseDto> create(CuentaRequestDto cuentaRequestDto) {
        return this.cuentaRepository.save(toModel(cuentaRequestDto))
                .map(CuentaMapper::toDto)
                .onErrorMap(ex -> new ResourceNotFoundException("Error el crear cuenta"));
    }

    @Override
    public Mono<CuentaResponseDto> update(Long id, CuentaRequestDto cuentaRequestDto) {
        return this.cuentaRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("Error al buscar Cuenta")))
                .flatMap(cuenta-> this.cuentaRepository.save(toModel(cuenta.getId(),cuentaRequestDto)))
                .map(CuentaMapper::toDto)
                .onErrorMap(ex -> new ResourceNotFoundException("Error el modificar cuenta"));
    }

    @Override
    public Mono<Cuenta> existAccount(Long id, CuentaRequestDto ac) {
        return cuentaRepository.findById(id)
                .flatMap(cuenta -> {
                    if (ac.getNumero_cuenta() != null) {
                        cuenta.setNumero_cuenta(ac.getNumero_cuenta());
                    }
                    if (ac.getTipo_cuenta() != null) {
                        cuenta.setTipo_cuenta(ac.getTipo_cuenta());
                    }
                    if (ac.getSaldo_inicial() != 0) {
                        cuenta.setSaldo_inicial(ac.getSaldo_inicial());
                    }
                    if (ac.getEstado() != null) {
                        cuenta.setEstado(ac.getEstado());
                    }
                    if (ac.getId_cliente() != null) {
                        cuenta.setId_cliente(ac.getId_cliente());
                    }
                    return cuentaRepository.save(cuenta);
                });
    }

    @Override
    public Mono<Void> delete(Long id) {
        return this.cuentaRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException(("La cuenta no fue encontrado"))))
                .flatMap(cuenta -> {
                    cuenta.setEstado("False");
                    return this.cuentaRepository.save(cuenta);
                })
                .doOnSuccess(unused -> log.info("Se elimino el usuario"))
                .then();
    }
}
