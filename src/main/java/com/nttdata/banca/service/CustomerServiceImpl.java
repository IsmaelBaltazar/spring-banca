package com.nttdata.banca.service;

import com.nttdata.banca.model.document.Customer;
import com.nttdata.banca.model.repository.CustomerRepository;
import com.nttdata.banca.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    SequenceGeneratorService sequenceService;
    @Override
    public Flux<Customer> getAll() {
        return this.customerRepository.findAll();
    }
    @Override
    public Mono<Customer> save(Customer customer) {
        if (customer.getType().equalsIgnoreCase("personal")){
            if (customer.getEnterpriseCustomer()!=null){
                return null;
            }
        }else{
            if (customer.getPersonalCustomer()!=null){
                return null;
            }
        }
        customer.setIdCustomer(sequenceService.getSequenceNumber(Customer.SEQUENCE_NAME));
        return this.customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> update(Customer customer) {
        if (customer.getType().equalsIgnoreCase("personal")){
            if (customer.getEnterpriseCustomer()!=null){
                return null;
            }
        }else{
            if (customer.getPersonalCustomer()!=null){
                return null;
            }
        }
        return this.customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> findById(Long id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(Long id) {
        return this.customerRepository.existsById(id);
    }

}
