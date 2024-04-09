package com.example.persona.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaDto {
    private Long id;
    private String nombre;
    private String genero;
    private Integer edad;
    private Integer identificacion;
    private String direccion;
    private Integer telefono;

    public PersonaDto(Long id, String nombre, String genero, Integer edad, Integer identificacion, String direccion, Integer telefono) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "PersonaDto{" +
                "id_persona=" + id +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", edad=" + edad +
                ", identificacion=" + identificacion +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
