package com.todoapp.services;

import com.todoapp.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeService {
    public List<DtoEmployee> findAllEmployees();
}
