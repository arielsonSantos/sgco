package com.arielsonsantos.sgco.driver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/drivers")
public class DriverResource {

    @GetMapping()
    public String findAll() {
        return "Funcionando";
    }
}
