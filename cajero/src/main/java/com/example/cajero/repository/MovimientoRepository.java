package com.example.cajero.repository;

import com.example.cajero.domain.dto.ReporteDto.ReporteResponseDto;
import com.example.cajero.domain.model.Movimiento;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@Repository
public interface MovimientoRepository extends ReactiveCrudRepository<Movimiento,Long> {
    @Query("SELECT m.fecha, p.nombre as cliente, c.numero_cuenta as numerocuenta, c.tipo_cuenta as tipo, c.saldo_inicial as saldoinicial, c.estado, m.valor as movimiento, m.saldo as saldodisponible\n" +
            "FROM movimiento m \n" +
            "JOIN cuenta c ON m.id_cuenta = c.id \n" +
            "JOIN cliente cl ON c.id_cliente = cl.id\n" +
            "JOIN persona p ON cl.id_persona= p.id\n" +
            "WHERE m.fecha BETWEEN :fechaInicio AND :fechaFin \n" +
            "AND p.nombre = :cliente")
    Flux<ReporteResponseDto> generarReporteMovimientos(@Param("fechaInicio") LocalDate fechaInicio,
                                                       @Param("fechaFin") LocalDate fechaFin,
                                                       @Param("cliente") String cliente);
}
