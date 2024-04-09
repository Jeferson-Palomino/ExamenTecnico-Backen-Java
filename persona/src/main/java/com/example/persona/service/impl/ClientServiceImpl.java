package com.example.persona.service.impl;

import com.example.persona.domain.dto.ClienteRequestDto;
import com.example.persona.domain.dto.ClienteResponseDto;
import com.example.persona.domain.dto.PersonaDto;
import com.example.persona.domain.mapper.ClienteMapper;
import com.example.persona.domain.model.Cliente;
import com.example.persona.domain.model.Persona;
import com.example.persona.exception.ResourceNotFoundException;
import com.example.persona.repository.ClienteRepository;
import com.example.persona.repository.PersonaRepository;
import com.example.persona.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.persona.domain.mapper.ClienteMapper.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    private final ClienteRepository clienteRepository;
    private final PersonaRepository personaRepository;
    @Override
    public Flux<ClienteResponseDto> findAll() {
        return null;
    }

    @Override
    @Transactional
    public Mono<ClienteResponseDto> create(ClienteRequestDto cl) {
        logger.info("Este es clienterequest: {}", cl);

        return this.personaRepository.save(toModelo(cl))
                .flatMap(savedPerson -> this.personaRepository.findLastId()
                        .flatMap(id ->
                        {
                            cl.setId(id);
                            logger.info("Este es clienterequest: {}", id);
                            return this.clienteRepository.save(toModeloClient(id,cl))
                                    .map(ClienteMapper::toDto)
                                    .onErrorMap(ex -> new ResourceNotFoundException("Error el crear cliente"));
                        }));
    }

    @Override
    public Mono<ClienteResponseDto> update(Long id, ClienteRequestDto cl) {
        return this.clienteRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El cliente " +id+"no fue encontrado")))
                .flatMap(cliente-> {
                        cliente.setContrasena(cl.getContrasena());
                        cliente.setEstado(cl.getEstado());
                        Mono<Cliente> updatedClient = this.clienteRepository.updateCliente(cliente.getId(), cliente.getContrasena(), cliente.getEstado());
                        logger.info("este es id: {}",cliente.getId_persona());
                        Mono<Persona> updatedPerson = this.personaRepository.findById(cliente.getId_persona())
                                .switchIfEmpty(Mono.error(new ResourceNotFoundException("La persona asociada al cliente no fue encontrada")))
                                .flatMap(persona -> {
                                    persona.setNombre(cl.getNombre());
                                    persona.setGenero(cl.getGenero());
                                    persona.setEdad(cl.getEdad());
                                    persona.setIdentificacion(cl.getIdentificacion());
                                    persona.setDireccion(cl.getDireccion());
                                    persona.setTelefono(cl.getTelefono());
                                    return this.personaRepository.save(persona);
                                });
                        return updatedClient
                                .then(updatedPerson)
                                .thenReturn(ClienteMapper.toDto(cliente));
                });

    }

    @Override
    public Mono<Void> delete(Long id) {
        return this.clienteRepository.findById(id)
                .flatMap(cliente -> {
                    Mono<Void> deletePerson = this.personaRepository.deleteById(cliente.getId_persona());
                    Mono<Void> deleteClient = this.clienteRepository.deleteById(id);
                    return deleteClient.then(deletePerson);
                });
    }

    @Override
    public Flux<ClienteResponseDto> findAllClientAndPerson(){
        return this.clienteRepository.findClienteByPerson()
                .map(ClienteMapper::toDto);
    }
}
