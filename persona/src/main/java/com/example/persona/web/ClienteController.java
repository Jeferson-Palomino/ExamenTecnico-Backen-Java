package com.example.persona.web;

import com.example.persona.domain.dto.ClienteRequestDto;
import com.example.persona.domain.dto.ClienteResponseDto;
import com.example.persona.domain.model.Cliente;
import com.example.persona.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public Flux<ClienteResponseDto> findAll(){return this.clientService.findAllClientAndPerson();}

    @PostMapping
    public Mono<ClienteResponseDto> save(@RequestBody ClienteRequestDto cl){
        return this.clientService.create(cl);
    }

    @PutMapping("/{id}")
    public Mono<ClienteResponseDto> update(@PathVariable Long id, @RequestBody ClienteRequestDto cl){
        return this.clientService.update(id,cl);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id){
        return this.clientService.delete(id);
    }
}
