package com.example.cajero.domain.mapper.CuentaMapper;

import com.example.cajero.domain.dto.CuentaDto.CuentaRequestDto;
import com.example.cajero.domain.dto.CuentaDto.CuentaResponseDto;
import com.example.cajero.domain.model.Cuenta;

public class CuentaMapper {
    public static Cuenta toModel(CuentaRequestDto dto){
        return new Cuenta(
                dto.getNumero_cuenta(),
                dto.getTipo_cuenta(),
                dto.getSaldo_inicial(),
                dto.getEstado(),
                dto.getId_cliente()
        );
    }
    public static Cuenta toModel(Long id,CuentaRequestDto dto){
        return new Cuenta(
                id,
                dto.getNumero_cuenta(),
                dto.getTipo_cuenta(),
                dto.getSaldo_inicial(),
                dto.getEstado(),
                dto.getId_cliente()
        );
    }


    public static CuentaResponseDto toDto(Cuenta cu){
        return new CuentaResponseDto(
                cu.getId(),
                cu.getNumero_cuenta(),
                cu.getTipo_cuenta(),
                cu.getSaldo_inicial(),
                cu.getEstado(),
                cu.getId_cliente()
        );
    }
}
