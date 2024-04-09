package com.example.persona.domain.dto;

import lombok.Data;


@Data
public class ClienteRequestDto {
    private Long id;
    private String nombre;
    private String genero;
    private Integer edad;
    private Integer identificacion;
    private String direccion;
    private Integer telefono;
    private String contrasena;
    private String estado;

}
