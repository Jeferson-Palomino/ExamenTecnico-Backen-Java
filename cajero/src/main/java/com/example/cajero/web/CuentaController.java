package com.example.cajero.web;

import com.example.cajero.domain.dto.CuentaDto.CuentaRequestDto;
import com.example.cajero.domain.dto.CuentaDto.CuentaResponseDto;
import com.example.cajero.domain.model.Cuenta;
import com.example.cajero.service.CuentaService.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    CuentaService cuentaService;

    @GetMapping
    public Flux<CuentaResponseDto> findAll(){return this.cuentaService.findAll();}

    @PostMapping
    public Mono<CuentaResponseDto> create(@RequestBody CuentaRequestDto cuentaRequestDto){
        return this.cuentaService.create(cuentaRequestDto);
    }

    @PutMapping("/{id}")
    public Mono<CuentaResponseDto> update(@PathVariable Long id, @RequestBody CuentaRequestDto requestDto){
        return this.cuentaService.update(id,requestDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id){return this.cuentaService.delete(id);}

    @PatchMapping("/{id}")
    public Mono<ResponseEntity<Cuenta>> actualizarParcialmenteCuenta(@PathVariable Long id, @RequestBody CuentaRequestDto cuentaActualizada) {
        return cuentaService.existAccount(id, cuentaActualizada)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
