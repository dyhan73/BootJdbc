package com.example.customerlog4jdbc;

import com.example.customerlog4jdbc.domain.Customer;
import com.example.customerlog4jdbc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerLog4jdbcApplication implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        // add data
        Customer created = customerRepository.save(new Customer(
                null, "수빈", "한"
        ));
        System.out.println(created + " is created");

        // display data
        customerRepository.findAll().forEach(System.out::println);
    }
    public static void main(String[] args) {
        SpringApplication.run(CustomerLog4jdbcApplication.class, args);
    }
}
