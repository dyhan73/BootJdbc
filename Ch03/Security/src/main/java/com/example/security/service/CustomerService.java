package com.example.security.service;

import com.example.security.domain.Customer;
import com.example.security.domain.User;
import com.example.security.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAllOrderByName();
    }

    public Customer findOne(Integer id) {
        return customerRepository.findById(id).get();
    }

    public Customer create(Customer customer, User user) {
        customer.setUser(user);
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer, User user) {
        customer.setUser(user);
        return customerRepository.save(customer);
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
