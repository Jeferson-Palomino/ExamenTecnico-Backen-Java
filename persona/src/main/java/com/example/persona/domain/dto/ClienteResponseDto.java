package com.example.persona.domain.dto;

import lombok.Data;

@Data
public class ClienteResponseDto extends PersonaDto{
    private String contrasena;
    private String estado;

    public ClienteResponseDto(Long id,String nombre, String genero, Integer edad, Integer identificacion, String direccion, Integer telefono, String contrasena, String estado) {
        super(id,nombre, genero, edad, identificacion, direccion, telefono);
        this.contrasena = contrasena;
        this.estado = estado;
    }

}
