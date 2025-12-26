package com.todoapp.controller;

import com.todoapp.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeController {

    public List<DtoEmployee> findAllEmployees();

}
