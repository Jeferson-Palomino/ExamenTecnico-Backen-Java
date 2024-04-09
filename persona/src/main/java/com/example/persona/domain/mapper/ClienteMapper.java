package com.example.persona.domain.mapper;

import com.example.persona.domain.dto.ClienteRequestDto;
import com.example.persona.domain.dto.ClienteResponseDto;
import com.example.persona.domain.dto.PersonaDto;
import com.example.persona.domain.model.Cliente;
import com.example.persona.domain.model.Persona;

public class ClienteMapper {

    public static Cliente toModel(ClienteRequestDto dto){
        return new Cliente(
                dto.getNombre(),
                dto.getGenero(),
                dto.getEdad(),
                dto.getIdentificacion(),
                dto.getDireccion(),
                dto.getTelefono(),
                dto.getContrasena(),
                dto.getEstado()
        );
    }
    public static Cliente toModel(Long id,ClienteRequestDto dto){
        return new Cliente(
                id,
                dto.getNombre(),
                dto.getGenero(),
                dto.getEdad(),
                dto.getIdentificacion(),
                dto.getDireccion(),
                dto.getTelefono(),
                dto.getContrasena(),
                dto.getEstado()
        );
    }

    public static Persona toModelo(ClienteRequestDto dto){
        return new Persona(
                dto.getNombre(),
                dto.getGenero(),
                dto.getEdad(),
                dto.getIdentificacion(),
                dto.getDireccion(),
                dto.getTelefono()
        );
    }
    public static Cliente toModeloClient(long id,ClienteRequestDto clienteRequestDto){
        return new Cliente(
                id,
                clienteRequestDto.getContrasena(),
                clienteRequestDto.getEstado()
        );
    }

    public static ClienteResponseDto toDto(Cliente cliente){
        return new ClienteResponseDto(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getGenero(),
                cliente.getEdad(),
                cliente.getIdentificacion(),
                cliente.getDireccion(),
                cliente.getTelefono(),
                cliente.getContrasena(),
                cliente.getEstado()
        );
    }
}
