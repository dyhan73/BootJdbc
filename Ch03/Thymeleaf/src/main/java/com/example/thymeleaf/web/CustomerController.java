package com.example.thymeleaf.web;

import com.example.thymeleaf.domain.Customer;
import com.example.thymeleaf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }
}
