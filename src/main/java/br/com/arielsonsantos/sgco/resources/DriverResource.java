package br.com.arielsonsantos.sgco.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverResource {

    @RequestMapping(value = "/drivers")
    public String findAll() {
        return "Funcionando";
    }
}
