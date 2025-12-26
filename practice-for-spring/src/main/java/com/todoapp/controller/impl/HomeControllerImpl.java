package com.todoapp.controller.impl;

import com.todoapp.controller.IHomeController;
import com.todoapp.dto.DtoHome;
import com.todoapp.services.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController()
@RequestMapping("/home")
public class HomeControllerImpl implements IHomeController {

    @Autowired
    private IHomeService homeService;

    @GetMapping(path = "/{id}")
    @Override
    public DtoHome findHomeById(@PathVariable Long id) {
        return homeService.findHomeById(id);
    }
}
