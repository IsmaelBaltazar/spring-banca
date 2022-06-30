package com.nttdata.banca.service;

import com.nttdata.banca.model.document.Movement;
import com.nttdata.banca.model.repository.MovementRepository;
import com.nttdata.banca.model.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class MovementServiceImpl implements MovementService {
    @Autowired
    private MovementRepository movementRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public Flux<Movement> getAll() {
        return movementRepository.findAll();
    }

    @Override
    public Mono<Movement> save(Movement movement) {
        movement.setIdMovement(sequenceGeneratorService.getSequenceNumber(Movement.SEQUENCE_NAME));
        return movementRepository.save(movement);
    }

    @Override
    public Mono<Movement> getOne(Long idMovement) {
        return movementRepository.findById(idMovement);
    }

    @Override
    public Mono<Movement> update(Movement movement) {
        return movementRepository.save(movement);
    }
}
