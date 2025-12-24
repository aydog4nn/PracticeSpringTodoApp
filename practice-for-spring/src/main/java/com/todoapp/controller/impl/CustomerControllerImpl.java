package com.todoapp.controller.impl;

import com.todoapp.controller.ICustomerController;
import com.todoapp.dto.DtoCustomer;
import com.todoapp.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer")
public class CustomerControllerImpl implements ICustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoCustomer findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }
}
