package com.todoapp.services;

import com.todoapp.dto.DtoCustomer;

public interface ICustomerService {


    DtoCustomer findCustomerById(Long id);
}
