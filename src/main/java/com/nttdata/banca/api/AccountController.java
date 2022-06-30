package com.nttdata.banca.api;

import com.nttdata.banca.model.document.Account;
import com.nttdata.banca.model.document.Customer;
import com.nttdata.banca.model.service.AccountService;
import com.nttdata.banca.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private SequenceGeneratorService sequenceService;

    @PostMapping
    public Mono<Account> register(@RequestBody Account account){
        return accountService.save(account);
    }
    @GetMapping("")
    public Flux<Account> getAll(){
        return accountService.getAll();
    }

    @GetMapping("/{idAccount}")
    public Mono<Account> getOne(@PathVariable Long idAccount){
        return accountService.findById(idAccount);
    }
    @PutMapping
    public Mono<Account> update(@RequestBody Account account){
        return  accountService.update(account);
    }
}
