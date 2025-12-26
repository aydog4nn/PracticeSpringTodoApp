package com.todoapp.controller;

import com.todoapp.dto.DtoHome;

public interface IHomeController {
    public DtoHome findHomeById(Long id);
}
