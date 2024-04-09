package com.example.persona.repository;

import com.example.persona.domain.dto.ClienteResponseDto;
import com.example.persona.domain.model.Cliente;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ClienteRepository extends ReactiveCrudRepository<Cliente,Long> {
    @Query("SELECT c.*, p.* FROM cliente c LEFT JOIN persona p ON c.id_persona = p.id")
    Flux<Cliente> findClienteByPerson();

    @Modifying
    @Query("UPDATE cliente SET contrasena = :contrasena, estado = :estado WHERE id = :id")
    Mono<Cliente> updateCliente(Long id, String contrasena, String estado);
}
