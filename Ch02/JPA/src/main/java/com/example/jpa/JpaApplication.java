package com.example.jpa;

import com.example.jpa.domain.Customer;
import com.example.jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
    @Autowired
    CustomerRepository customerRepository;

    public void insertCustomer(String firstName, String lastName) {
        Customer created = customerRepository.save(new Customer(null, firstName, lastName));
        System.out.println(created + " is created");
    }

    @Override
    public void run(String... args) throws Exception {
        // add data
        insertCustomer("대영", "한");
        insertCustomer("혜경", "안");
        insertCustomer("주후", "김");
        insertCustomer("수빈", "한");

        // display data
        System.out.println("Result of FindAll()");
        customerRepository.findAll().forEach(System.out::println);

        System.out.println("Result os FindAllOrderByName()");
        customerRepository.findAllOrderByName().forEach(System.out::println);
    }
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
}