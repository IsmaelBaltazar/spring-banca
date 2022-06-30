package com.nttdata.banca.model.service;


import com.nttdata.banca.model.document.Movement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementService {
    Flux<Movement> getAll();
    Mono<Movement> save(Movement movement);
    Mono<Movement> getOne(Long idMovement);
    Mono<Movement> update(Movement movement);
}
