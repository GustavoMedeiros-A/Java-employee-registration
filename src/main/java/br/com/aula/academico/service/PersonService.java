package br.com.aula.academico.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aula.academico.model.Person;
import br.com.aula.academico.service.dao.PersonDao;

@Service
public class PersonService {

    @Autowired
    PersonDao persondao;

    public boolean isValid(Person person) {
        return (person.getPayCheck() >= 1000);
    }

    public Person save(Person person) {
        return persondao.save(person);
    }

    public Person getPerson(int id) {
        return persondao.findById(id);
    }

    public double catchPersonSalary(Person person, int id) {
        return person.freePayCheck(person);

    }



}
