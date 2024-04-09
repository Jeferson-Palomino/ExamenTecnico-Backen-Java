package com.example.cajero.service.MovimientoService.impl;

import com.example.cajero.domain.dto.MovimientoDto.MovimientoRequestDto;
import com.example.cajero.domain.dto.MovimientoDto.MovimientoResponseDto;
import com.example.cajero.domain.dto.ReporteDto.ReporteResponseDto;
import com.example.cajero.domain.mapper.MoviminetoMapper.MovimientoMapper;
import com.example.cajero.domain.model.Movimiento;
import com.example.cajero.exception.ResourceNotFoundException;
import com.example.cajero.repository.CuentaRepository;
import com.example.cajero.repository.MovimientoRepository;
import com.example.cajero.service.MovimientoService.MovimientoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static com.example.cajero.domain.mapper.MoviminetoMapper.MovimientoMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private  final CuentaRepository cuentaRepository;
    @Override
    public Flux<MovimientoResponseDto> findAll() {
        return this.movimientoRepository.findAll()
                .map(MovimientoMapper::toDto);
    }

    @Override
    public Mono<Void> create(MovimientoRequestDto movimientoRequestDto) {
        return this.cuentaRepository.findById(movimientoRequestDto.getId_cuenta())
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("La cuenta no existe")))
                .flatMap(cuenta -> {
                    if (movimientoRequestDto.getTipo_movimiento().equals("Retiro")){
                        if (cuenta.getSaldo_inicial()< movimientoRequestDto.getValor()){
                            return Mono.error(new ResourceNotFoundException("Cuenta insuficiente"));
                        }
                        cuenta.setSaldo_inicial(cuenta.getSaldo_inicial()- movimientoRequestDto.getValor());
                    } else if (movimientoRequestDto.getTipo_movimiento().equals("Deposito")) {
                        cuenta.setSaldo_inicial(cuenta.getSaldo_inicial()+ movimientoRequestDto.getValor());
                    }else {
                        return Mono.error(new ResourceNotFoundException("El tipo de movimiento es inválido"));
                    }
                    Movimiento movimiento = new Movimiento();
                    movimiento.setId_cuenta(cuenta.getId());
                    movimiento.setTipo_movimiento(movimientoRequestDto.getTipo_movimiento());
                    movimiento.setValor(movimientoRequestDto.getValor());
                    movimiento.setSaldo(cuenta.getSaldo_inicial());

                    return movimientoRepository.save(movimiento)
                            .then(cuentaRepository.save(cuenta))
                            .then();
                });
    }

    @Override
    public Mono<MovimientoResponseDto> update(Long id, MovimientoRequestDto movimientoRequestDto) {
        return null;
    }

    @Override
    public Mono<Void> delete(Long id) {
        return this.movimientoRepository.deleteById(id)
                .doOnSuccess(unused -> log.info("Se elimino el movimiento con identificador: {}",id));
    }

    @Override
    public Flux<ReporteResponseDto> generarReporteMovimientos(LocalDate fechaInicio, LocalDate fechaFin, String cliente) {
        return this.movimientoRepository.generarReporteMovimientos(fechaInicio,fechaFin,cliente);

    }

}
