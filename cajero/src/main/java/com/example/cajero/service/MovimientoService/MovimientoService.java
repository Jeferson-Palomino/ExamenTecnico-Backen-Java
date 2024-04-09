package com.example.cajero.service.MovimientoService;

import com.example.cajero.domain.dto.MovimientoDto.MovimientoRequestDto;
import com.example.cajero.domain.dto.MovimientoDto.MovimientoResponseDto;
import com.example.cajero.domain.dto.ReporteDto.ReporteResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public interface MovimientoService {
    Flux<MovimientoResponseDto> findAll();
    Mono<Void> create(MovimientoRequestDto movimientoRequestDto);
    Mono<MovimientoResponseDto> update(Long id , MovimientoRequestDto movimientoRequestDto);
    Mono<Void> delete(Long id);

    Flux<ReporteResponseDto> generarReporteMovimientos(LocalDate fechaInicio, LocalDate fechaFin, String cliente);
}
