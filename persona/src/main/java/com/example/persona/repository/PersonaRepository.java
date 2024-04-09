package com.example.persona.repository;

import com.example.persona.domain.model.Persona;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PersonaRepository extends ReactiveCrudRepository<Persona, Long> {
    @Query("SELECT MAX(id) FROM persona")
    Mono<Long> findLastId();
}
