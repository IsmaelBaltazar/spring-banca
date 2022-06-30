package com.nttdata.banca.model.service;

import com.nttdata.banca.model.document.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
    Flux<Customer> getAll();
    Mono<Customer> save(Customer customer);
    Mono<Customer> update(Customer customer);
    Mono<Customer> findById(Long id);
    Mono<Boolean> existsById(Long id);
}
