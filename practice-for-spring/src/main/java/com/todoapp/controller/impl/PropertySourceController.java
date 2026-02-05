package com.todoapp.controller.impl;

import com.todoapp.configuration.DataSource;
import com.todoapp.configuration.GlobalProperties;
import com.todoapp.configuration.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertySourceController {

    @Autowired
    private GlobalProperties globalProperties;

    @GetMapping("/datasource")
    public DataSource GetDataSource(){

      return null;
    }

    @GetMapping(value = "/getServers")
    public List<Server> getServers(){
        return globalProperties.getServers();
    }

}
