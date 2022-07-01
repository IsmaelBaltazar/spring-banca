package com.nttdata.banca.model.service;

import com.nttdata.banca.model.document.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
    Flux<Account> getAll();
    Mono<Account> save(Account account);
    Mono<Account> update(Account account);
    Mono<Account> findById(Long idAccount);
}
