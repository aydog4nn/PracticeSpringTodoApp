package com.todoapp.controller;

import com.todoapp.dto.DtoCustomer;

public interface ICustomerController {

    public DtoCustomer findCustomerById(Long id);

}
