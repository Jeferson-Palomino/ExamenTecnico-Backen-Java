package com.example.persona.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "persona")
@Getter
@Setter
@NoArgsConstructor
public class Persona {
    @Id
    private Long id;
    private String nombre;
    private String genero;
    private Integer edad;
    private Integer identificacion;
    private String direccion;
    private Integer telefono;

    public Persona(Long id, String nombre, String genero, Integer edad, Integer identificacion, String direccion, Integer telefono) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Persona(String nombre, String genero, Integer edad, Integer identificacion, String direccion, Integer telefono) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

}
