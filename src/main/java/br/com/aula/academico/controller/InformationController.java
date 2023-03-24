package br.com.aula.academico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class InformationController {

    @GetMapping()
    public String home() {
        return "Funcionando";
    }
}
