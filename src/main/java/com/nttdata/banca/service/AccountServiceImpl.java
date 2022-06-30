package com.nttdata.banca.service;

import com.nttdata.banca.model.document.Account;
import com.nttdata.banca.model.document.Customer;
import com.nttdata.banca.model.repository.AccountRepository;
import com.nttdata.banca.model.repository.CustomerRepository;
import com.nttdata.banca.model.service.AccountService;
import com.nttdata.banca.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private SequenceGeneratorService sequenceService;

    @Override
    public Flux<Account> getAll() {
       return accountRepository.findAll();
    }

    @Override
    public Mono<Account> save(Account account) {
        account.setIdAccount(sequenceService.getSequenceNumber(account.SEQUENCE_NAME));
        return accountRepository.save(account);
    }

    @Override
    public Mono<Account> update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Mono<Account> findById(Long idAccount) {
        return accountRepository.findById(idAccount);
    }
}
