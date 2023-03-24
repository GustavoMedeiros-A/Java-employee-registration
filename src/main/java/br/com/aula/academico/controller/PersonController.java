package br.com.aula.academico.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aula.academico.model.Person;
import br.com.aula.academico.service.PersonService;

@RestController //RestFul webService
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    PersonService personService;

    @PostMapping
    public Person savePerson(@RequestBody @Valid Person person) {
        if(personService.isValid(person)) {
            return personService.save(person);
        } else {
            return null;
        }
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable int id) {
        return personService.getPerson(id);
    }
    
    @GetMapping("/salary/{id}") 
    private int calculateSalary(@PathVariable int id) {
        Person person = personService.getPerson(id);
        return (int) person.freePayCheck(person);
    }

}
