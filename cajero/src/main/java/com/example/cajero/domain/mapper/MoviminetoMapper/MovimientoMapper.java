package com.example.cajero.domain.mapper.MoviminetoMapper;


import com.example.cajero.domain.dto.MovimientoDto.MovimientoRequestDto;
import com.example.cajero.domain.dto.MovimientoDto.MovimientoResponseDto;
import com.example.cajero.domain.dto.ReporteDto.ReporteResponseDto;
import com.example.cajero.domain.model.Movimiento;

public class MovimientoMapper {
    public static Movimiento toModel(MovimientoRequestDto dto){
        return new Movimiento(
                dto.getId_cuenta(),
                dto.getFecha(),
                dto.getTipo_movimiento(),
                dto.getValor(),
                dto.getSaldo()
        );
    }
    public static Movimiento toModel(Long id,MovimientoRequestDto dto){
        return new Movimiento(
                id,
                dto.getId_cuenta(),
                dto.getFecha(),
                dto.getTipo_movimiento(),
                dto.getValor(),
                dto.getSaldo()
        );
    }


    public static MovimientoResponseDto toDto(Movimiento cu){
        return new MovimientoResponseDto(
                cu.getId(),
                cu.getId_cuenta(),
                cu.getFecha(),
                cu.getTipo_movimiento(),
                cu.getValor(),
                cu.getSaldo()
        );
    }

}
