package com.todoapp.services.impl;

import com.todoapp.dto.DtoAddress;
import com.todoapp.dto.DtoCustomer;
import com.todoapp.entity.Address;
import com.todoapp.entity.Customer;
import com.todoapp.repository.CustomerRepository;
import com.todoapp.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer findCustomerById(Long id){

        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();


        Optional<Customer> optional =  customerRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        else {
            Customer customer = optional.get();
            Address address = optional.get().getAddress();


            BeanUtils.copyProperties(customer,dtoCustomer);
            BeanUtils.copyProperties(address,dtoAddress);

            dtoCustomer.setAddress(dtoAddress);

            return dtoCustomer;

        }

    }
}
