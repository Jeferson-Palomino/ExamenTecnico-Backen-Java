package com.example.cajero.repository;

import com.example.cajero.domain.model.Cuenta;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends ReactiveCrudRepository<Cuenta,Long> {
}
