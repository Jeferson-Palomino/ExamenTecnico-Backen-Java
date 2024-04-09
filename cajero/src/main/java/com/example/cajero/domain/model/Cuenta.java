package com.example.cajero.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "cuenta")
@Getter
@Setter
@NoArgsConstructor
public class Cuenta {
    @Id
    private Long id;
    private String numero_cuenta;
    private String tipo_cuenta;
    private double saldo_inicial;
    private String estado;
    private Long id_cliente;

    public Cuenta(Long id, String numero_cuenta, String tipo_cuenta, double saldo_inicial, String estado, Long id_cliente) {
        this.id = id;
        this.numero_cuenta = numero_cuenta;
        this.tipo_cuenta = tipo_cuenta;
        this.saldo_inicial = saldo_inicial;
        this.estado = estado;
        this.id_cliente = id_cliente;
    }

    public Cuenta(String numero_cuenta, String tipo_cuenta, double saldo_inicial, String estado, Long id_cliente) {
        this.numero_cuenta = numero_cuenta;
        this.tipo_cuenta = tipo_cuenta;
        this.saldo_inicial = saldo_inicial;
        this.estado = estado;
        this.id_cliente = id_cliente;
    }
}