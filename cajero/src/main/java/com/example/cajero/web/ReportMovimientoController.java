package com.example.cajero.web;

import com.example.cajero.domain.dto.ReporteDto.ReporteResponseDto;
import com.example.cajero.service.MovimientoService.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

@RestController
@RequestMapping("/reportes")
public class ReportMovimientoController {
    @Autowired
    MovimientoService movimientoService;

    @GetMapping
    public Flux<ReporteResponseDto> generarReporteMovimientos(@RequestParam LocalDate fechaInicio,
                                                              @RequestParam LocalDate fechaFin,
                                                              @RequestParam String cliente) {
        return this.movimientoService.generarReporteMovimientos(fechaInicio, fechaFin, cliente);
    }
}
