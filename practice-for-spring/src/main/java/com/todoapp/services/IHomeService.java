package com.todoapp.services;

import com.todoapp.dto.DtoHome;

public interface IHomeService {

    public DtoHome findHomeById(Long id);

}
