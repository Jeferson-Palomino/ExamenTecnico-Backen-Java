package com.example.persona.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
public class Cliente extends Persona{

    private Long id_persona;
    private String contrasena;
    private String estado;

    public Cliente(Long id_persona, String contrasena, String estado) {
        this.id_persona = id_persona;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public Cliente(Long id, String nombre, String genero, Integer edad, Integer identificacion, String direccion, Integer telefono, String contrasena, String estado) {
        super(id, nombre, genero, edad, identificacion, direccion, telefono);
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public Cliente(String nombre, String genero, Integer edad, Integer identificacion, String direccion, Integer telefono, String contrasena, String estado) {
        super(nombre, genero, edad, identificacion, direccion, telefono);
        this.contrasena = contrasena;
        this.estado = estado;
    }
}
