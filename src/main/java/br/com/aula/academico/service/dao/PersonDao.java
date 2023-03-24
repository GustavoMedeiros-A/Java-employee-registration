package br.com.aula.academico.service.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aula.academico.model.Person;


// interface in java have no code/methods - just describe behaviour
@Repository
public interface PersonDao extends JpaRepository<Person, Integer>{ //Classe que herda e qual o tipo da chave primária

    Person save(String string);

    Person findById(int id);

    // double getSalary(int id);
    
}
