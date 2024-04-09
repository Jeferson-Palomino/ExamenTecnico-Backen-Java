package com.example.cajero.web;

import com.example.cajero.domain.dto.MovimientoDto.MovimientoRequestDto;
import com.example.cajero.domain.dto.MovimientoDto.MovimientoResponseDto;
import com.example.cajero.service.MovimientoService.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    @Autowired
    MovimientoService movimientoService;

    @GetMapping
    public Flux<MovimientoResponseDto> findAll(){return this.movimientoService.findAll();}

    @PostMapping
    public Mono<Void> create(@RequestBody MovimientoRequestDto movimientoRequestDto){
        return this.movimientoService.create(movimientoRequestDto);
    }

    @PutMapping("/{id}")
    public Mono<MovimientoResponseDto> update(@PathVariable Long id,@RequestBody MovimientoRequestDto movimientoRequestDto){return this.movimientoService.update(id,movimientoRequestDto);}
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id){return  this.movimientoService.delete(id);}
}
